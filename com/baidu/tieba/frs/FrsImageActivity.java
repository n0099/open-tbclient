package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.data.ThreadWaterData;
import com.baidu.tieba.model.FrsWaterFallModel;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsHeaderView;
import com.baidu.tieba.view.FrsWaterFallImageView;
import com.baidu.tieba.view.FrsWaterFallItem;
import com.baidu.tieba.view.WaterFallView;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.tieba.write.WriteUtil;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsImageActivity extends BaseActivity {
    private static final String ADD_SEARCH = "add_search";
    private static final String CURRENT_PAGE = "current_page";
    private static final String FROM = "from";
    private static final String NAME = "name";
    private static final String URL_ST_TYPE = "st_type";
    private static final int WRITE_PIC = 1;
    private static final int WRITE_TEXT = 0;
    private int mImageWidth = 0;
    private WaterFallView mWaterFallView = null;
    private String mForumName = null;
    private GetListTask mListTask = null;
    private PullListTask mPullListTask = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnClickListener mItemOnClickListener = null;
    private Button mButtonBack = null;
    private Button mButtonHome = null;
    private AsyncImageLoader mAsyncImageLoader = null;
    private AsyncImageLoader.ImageCallback mImageCallback1 = null;
    private AsyncImageLoader.ImageCallback mImageCallback2 = null;
    private WaterFallView.OnScrollListener mOnScrollListener = null;
    private TextView mTitleText = null;
    private FrsWaterFallModel mModel = null;
    private int mItemTitleHeight = 0;
    private int mItemNameHeight = 0;
    private FooterType mCurrentFootType = FooterType.GONE;
    private int mCurrentIndex = 0;
    private int mCurrentPage = 1;
    private FrsHeaderView mHeader = null;
    private Button mButtonWrite = null;
    private Button mButtonRefresh = null;
    private Button mButtonCamera = null;
    private AlertDialog mSelectImageDialog = null;
    private String mFrom = null;
    private int mAddSearch = 0;
    private Rect mRect = new Rect();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum FooterType {
        NORMAL,
        LOADING,
        NEXT,
        LAST,
        GONE,
        NO_ITEM;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static FooterType[] valuesCustom() {
            FooterType[] valuesCustom = values();
            int length = valuesCustom.length;
            FooterType[] footerTypeArr = new FooterType[length];
            System.arraycopy(valuesCustom, 0, footerTypeArr, 0, length);
            return footerTypeArr;
        }
    }

    public static void startAcitivity(Context context, String name, String from, int add_search) {
        if (name != null && name.length() > 0) {
            Intent intent = new Intent(context, FrsImageActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("from", from);
            intent.putExtra(ADD_SEARCH, add_search);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frs_image_activity);
        initUI();
        initData(savedInstanceState);
    }

    private void initUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v != FrsImageActivity.this.mButtonBack) {
                    if (v != FrsImageActivity.this.mButtonHome) {
                        if (v != FrsImageActivity.this.mButtonWrite) {
                            if (v != FrsImageActivity.this.mButtonRefresh) {
                                if (v != FrsImageActivity.this.mButtonCamera) {
                                    return;
                                }
                                FrsImageActivity.this.writeBlog(1);
                                return;
                            }
                            FrsImageActivity.this.startListTask(1);
                            return;
                        }
                        FrsImageActivity.this.writeBlog(0);
                        return;
                    }
                    MainTabActivity.startActivity(FrsImageActivity.this, MainTabActivity.GOTO_RECOMMEND);
                    FrsImageActivity.this.finish();
                    return;
                }
                FrsImageActivity.this.finish();
            }
        };
        this.mItemOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.getTag() != null && (v.getTag() instanceof ThreadWaterData)) {
                    ThreadWaterData data = (ThreadWaterData) v.getTag();
                    ImagePbActivity.startAcitivity(FrsImageActivity.this, data.getTid(), FrsImageActivity.this.mForumName, data.getTitle());
                }
            }
        };
        this.mImageCallback1 = new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.frs.FrsImageActivity.3
            @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
            public void imageLoaded(Bitmap bitmap, String imageUrl, boolean isCached) {
                try {
                    View view = FrsImageActivity.this.mWaterFallView.getLine(1).findViewWithTag(imageUrl);
                    if (view != null && (view instanceof FrsWaterFallImageView)) {
                        boolean ret = view.getLocalVisibleRect(FrsImageActivity.this.mRect);
                        if (ret) {
                            if (FrsImageActivity.this.mRect.bottom - FrsImageActivity.this.mRect.top < view.getHeight() || FrsImageActivity.this.mRect.top == 0) {
                                ((FrsWaterFallImageView) view).startAnim();
                            } else {
                                view.invalidate();
                            }
                        } else {
                            view.invalidate();
                        }
                    }
                } catch (Exception ex) {
                    TiebaLog.e(getClass().getName(), "imageLoaded", ex.getMessage());
                }
            }
        };
        this.mImageCallback2 = new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.frs.FrsImageActivity.4
            @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
            public void imageLoaded(Bitmap bitmap, String imageUrl, boolean isCached) {
                try {
                    View view = FrsImageActivity.this.mWaterFallView.getLine(2).findViewWithTag(imageUrl);
                    if (view != null && (view instanceof FrsWaterFallImageView)) {
                        boolean ret = view.getLocalVisibleRect(FrsImageActivity.this.mRect);
                        if (ret) {
                            if (FrsImageActivity.this.mRect.bottom - FrsImageActivity.this.mRect.top < view.getHeight() || FrsImageActivity.this.mRect.top == 0) {
                                ((FrsWaterFallImageView) view).startAnim();
                            } else {
                                view.invalidate();
                            }
                        } else {
                            view.invalidate();
                        }
                    }
                } catch (Exception ex) {
                    TiebaLog.e(getClass().getName(), "imageLoaded", ex.getMessage());
                }
            }
        };
        this.mOnScrollListener = new WaterFallView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsImageActivity.5
            @Override // com.baidu.tieba.view.WaterFallView.OnScrollListener
            public void onBottom() {
                FrsImageActivity.this.startPullListTask(FrsImageActivity.this.mCurrentIndex);
            }

            @Override // com.baidu.tieba.view.WaterFallView.OnScrollListener
            public void onTop() {
                FrsImageActivity.this.LoadBitmap();
            }

            @Override // com.baidu.tieba.view.WaterFallView.OnScrollListener
            public void onScroll() {
            }

            @Override // com.baidu.tieba.view.WaterFallView.OnScrollListener
            public void onStop() {
                FrsImageActivity.this.LoadBitmap();
            }
        };
        this.mWaterFallView = (WaterFallView) findViewById(R.id.water_fall);
        initImageWidth(this.mWaterFallView.getLineWidth());
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
        this.mButtonBack = (Button) findViewById(R.id.back);
        this.mButtonBack.setOnClickListener(this.mOnClickListener);
        this.mButtonHome = (Button) findViewById(R.id.go_home);
        this.mButtonHome.setOnClickListener(this.mOnClickListener);
        this.mWaterFallView.setOnScrollListener(this.mOnScrollListener);
        this.mTitleText = (TextView) findViewById(R.id.title_text);
        this.mItemTitleHeight = UtilHelper.getFontHeight(this, 11.0f);
        this.mItemNameHeight = UtilHelper.getFontHeight(this, 10.0f);
        this.mButtonWrite = (Button) findViewById(R.id.frs_bt_post);
        this.mButtonWrite.setOnClickListener(this.mOnClickListener);
        this.mButtonRefresh = (Button) findViewById(R.id.frs_bt_refresh);
        this.mButtonRefresh.setOnClickListener(this.mOnClickListener);
        this.mButtonCamera = (Button) findViewById(R.id.frs_bt_camera);
        this.mButtonCamera.setOnClickListener(this.mOnClickListener);
        setFooter(FooterType.GONE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LoadBitmap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mAsyncImageLoader != null) {
            this.mAsyncImageLoader.cancelAllAsyncTask();
        }
    }

    private AlertDialog getImageDialog() {
        if (this.mSelectImageDialog != null) {
            return this.mSelectImageDialog;
        }
        String[] items = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.frs.FrsImageActivity.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    WriteUtil.takePhoto(FrsImageActivity.this);
                } else if (which == 1) {
                    WriteUtil.getAlbumImage(FrsImageActivity.this);
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeBlog(int type) {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            if (this.mModel != null && this.mModel.getAnti() != null) {
                this.mModel.getAnti().setIfpost(1);
            }
            if (type == 0) {
                LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_WRITE);
            } else {
                LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE);
            }
        } else if (this.mModel != null) {
            if (type == 0) {
                WriteActivity.startAcitivityForResult(this, this.mModel.getForum().getId(), this.mModel.getForum().getName(), this.mModel.getAnti(), false, null);
            } else {
                getImageDialog().show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case RequestResponseCode.REQUEST_LOGIN_WRITE /* 1100001 */:
                    writeBlog(0);
                    return;
                case RequestResponseCode.REQUEST_LOGIN_LIKE /* 1100002 */:
                    if (this.mHeader != null) {
                        this.mHeader.startLikeTask();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SIGN /* 1100014 */:
                    if (this.mHeader != null) {
                        this.mHeader.startSignTask();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 1100016 */:
                    getImageDialog().show();
                    return;
                case RequestResponseCode.REQUEST_CAMERA /* 1200001 */:
                    if (this.mModel != null && this.mModel.getForum() != null) {
                        WriteImageActivity.startActivityForResult(this, RequestResponseCode.REQUEST_CAMERA, RequestResponseCode.REQUEST_CAMERA_VIEW, null, this.mModel.getForum().getId(), this.mModel.getForum().getName(), this.mModel.getAnti());
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 1200002 */:
                    if (this.mModel != null && this.mModel.getForum() != null) {
                        if (data != null && data.getData() != null) {
                            WriteImageActivity.startActivityForResult(this, RequestResponseCode.REQUEST_ALBUM_IMAGE, RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, data.getData(), this.mModel.getForum().getId(), this.mModel.getForum().getName(), this.mModel.getAnti());
                            return;
                        } else {
                            WriteUtil.getAlbumImage(this);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (resultCode == 0) {
            switch (requestCode) {
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 1200008 */:
                    WriteUtil.getAlbumImage(this);
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12000010 */:
                    WriteUtil.takePhoto(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.mCurrentPage = savedInstanceState.getInt(CURRENT_PAGE);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_PAGE, this.mCurrentPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LoadBitmap() {
        boolean supportHold;
        NetWorkCore.NetworkStateInfo info = NetWorkCore.getStatusInfo(this);
        this.mAsyncImageLoader.clearHoldUrl();
        if (info == NetWorkCore.NetworkStateInfo.WIFI || info == NetWorkCore.NetworkStateInfo.ThreeG) {
            supportHold = true;
        } else {
            supportHold = false;
        }
        int max_height = UtilHelper.getEquipmentHeight(this) * 2;
        this.mAsyncImageLoader.setSupportHoldUrl(supportHold);
        int max_memory = Config.getBigImageMaxUsedMemory() >> 1;
        for (int i = 1; i <= 2; i++) {
            int memory = 0;
            LinearLayout line = this.mWaterFallView.getLine(i);
            int count = line.getChildCount();
            int first = this.mWaterFallView.getFirstVisibleIndex(i);
            int last = this.mWaterFallView.getLastVisibleIndex(i);
            int height = 0;
            if (first >= 0 && last >= 0) {
                while (true) {
                    if ((first <= last || supportHold) && first < count) {
                        FrsWaterFallItem view = (FrsWaterFallItem) line.getChildAt(first);
                        if (view != null) {
                            ThreadWaterData tag = (ThreadWaterData) view.getTag();
                            memory += tag.getImage().getImageDisplayHeight() * tag.getImage().getImageDisplayWidth() * 2;
                            if (memory > max_memory) {
                                break;
                            }
                            if (i == 1) {
                                this.mAsyncImageLoader.loadImage(tag.getImage().getId(), this.mImageCallback1);
                            } else {
                                this.mAsyncImageLoader.loadImage(tag.getImage().getId(), this.mImageCallback2);
                            }
                            height += tag.getImage().getImageDisplayHeight();
                            first++;
                            if (first <= last || height < max_height) {
                            }
                        }
                    }
                }
            }
        }
    }

    private void initImageWidth(int line_width) {
        LayoutInflater mInflater = LayoutInflater.from(this);
        LinearLayout view = (LinearLayout) mInflater.inflate(R.layout.water_fall_item, (ViewGroup) null);
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(line_width, 1073741824);
        view.measure(widthMeasureSpec, 0);
        View image = view.findViewById(R.id.image);
        this.mImageWidth = image.getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mListTask != null) {
            this.mListTask.cancel();
        }
        if (this.mPullListTask != null) {
            this.mPullListTask.cancel();
        }
        if (this.mHeader != null) {
            this.mHeader.release();
        }
    }

    private void addHeader() {
        if (this.mWaterFallView.getHeader() == null && this.mModel != null) {
            this.mHeader = new FrsHeaderView(this, FrsHeaderView.PAGE.FRS_IMAGE, this.mForumName, this.mModel.getForum().getId());
            this.mHeader.setHaveLike(this.mModel.getForum().isIs_like(), this.mModel.getForum().getLevelName(), this.mModel.getForum().getUser_level());
            this.mHeader.setHaveSign(this.mModel.getForum().getSignData().getSigned());
            if (this.mModel.getForum().getSignData().getForumRank() == -2) {
                this.mHeader.canSign(false);
            }
            this.mWaterFallView.addHeader(this.mHeader.getView());
        }
    }

    private View addFooter() {
        View view = this.mWaterFallView.getFooter();
        if (view == null) {
            LayoutInflater mInflater = LayoutInflater.from(this);
            View view2 = mInflater.inflate(R.layout.water_page, (ViewGroup) null);
            this.mWaterFallView.addFooter(view2);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsImageActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View paramView) {
                    if (FrsImageActivity.this.mCurrentFootType != FooterType.NEXT) {
                        return;
                    }
                    FrsImageActivity.this.startListTask(FrsImageActivity.this.mCurrentPage + Config.FRS_WATER_FALL_PAGE_NUM);
                }
            });
            return view2;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View addPrePage() {
        View view = this.mWaterFallView.getHeader2();
        if (view == null) {
            LayoutInflater mInflater = LayoutInflater.from(this);
            View view2 = mInflater.inflate(R.layout.water_page, (ViewGroup) null);
            view2.setVisibility(0);
            view2.setBackgroundColor(getResources().getColor(R.color.backgroundcolor));
            TextView text = (TextView) view2.findViewById(R.id.page_text);
            ProgressBar progress = (ProgressBar) view2.findViewById(R.id.progress);
            ImageView divider = (ImageView) view2.findViewById(R.id.divider);
            text.setText(R.string.pre_page);
            text.setVisibility(0);
            divider.setVisibility(0);
            progress.setVisibility(8);
            this.mWaterFallView.addHeader2(view2);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsImageActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View paramView) {
                    if (FrsImageActivity.this.mCurrentPage <= 240) {
                        return;
                    }
                    FrsImageActivity.this.startListTask(FrsImageActivity.this.mCurrentPage - 240);
                }
            });
            return view2;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePrePage() {
        this.mWaterFallView.removeHeader2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFooter(FooterType type) {
        View view = addFooter();
        TextView text = (TextView) view.findViewById(R.id.page_text);
        ProgressBar progress = (ProgressBar) view.findViewById(R.id.progress);
        ImageView divider = (ImageView) view.findViewById(R.id.divider);
        if (type == FooterType.NEXT) {
            view.setVisibility(0);
            text.setText(R.string.next_page);
            text.setVisibility(0);
            divider.setVisibility(0);
            progress.setVisibility(4);
        } else if (type == FooterType.LOADING) {
            view.setVisibility(0);
            text.setVisibility(4);
            progress.setVisibility(0);
            divider.setVisibility(8);
        } else if (type == FooterType.NORMAL) {
            view.setVisibility(0);
            text.setVisibility(4);
            progress.setVisibility(4);
            divider.setVisibility(8);
        } else if (type == FooterType.NO_ITEM) {
            view.setVisibility(0);
            text.setText(R.string.frs_no_image);
            text.setVisibility(0);
            progress.setVisibility(8);
            divider.setVisibility(8);
        } else {
            view.setVisibility(8);
        }
        this.mCurrentFootType = type;
    }

    private void initData(Bundle savedInstanceState) {
        this.mAsyncImageLoader = new AsyncImageLoader(this);
        this.mAsyncImageLoader.setImagesize(this.mImageWidth, 600);
        this.mAsyncImageLoader.setSuffix(AsyncImageLoader.WATER);
        this.mAsyncImageLoader.setNoPrefix(true);
        Intent intent = getIntent();
        this.mFrom = intent.getStringExtra("from");
        this.mAddSearch = intent.getIntExtra(ADD_SEARCH, 0);
        this.mForumName = intent.getStringExtra("name");
        this.mTitleText.setText(this.mForumName);
        if (savedInstanceState != null) {
            this.mCurrentPage = savedInstanceState.getInt(CURRENT_PAGE);
        }
        if (this.mCurrentPage < 1) {
            this.mCurrentPage = 1;
        }
        startListTask(this.mCurrentPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startListTask(int start) {
        if (this.mListTask == null) {
            if (this.mPullListTask != null) {
                this.mPullListTask.cancel();
            }
            this.mListTask = new GetListTask(start);
            this.mListTask.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPullListTask(int start) {
        if (this.mListTask == null && this.mPullListTask == null && this.mModel != null && this.mModel.getIdList().size() > start && this.mCurrentFootType == FooterType.NORMAL) {
            this.mPullListTask = new PullListTask(start);
            this.mPullListTask.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(ArrayList<ThreadWaterData> data) {
        if (data != null) {
            try {
                int num = data.size();
                for (int i = 0; i < num; i++) {
                    ThreadWaterData item = data.get(i);
                    if (item != null) {
                        int width = item.getImage().getImageOriWidth();
                        int height = item.getImage().getImageOriHeight();
                        if (width >= 100 && height >= 50) {
                            if (width > this.mImageWidth) {
                                float scale = this.mImageWidth / width;
                                width = this.mImageWidth;
                                height = (int) (height * scale);
                            }
                            if (height > 600) {
                                float scale2 = 600.0f / height;
                                height = 600;
                                width = (int) (width * scale2);
                            }
                            Bitmap bm = BitmapHelper.getCashBitmap(R.drawable.image_default);
                            if (height < bm.getHeight()) {
                                height = bm.getHeight();
                            }
                            LayoutInflater mInflater = LayoutInflater.from(this);
                            FrsWaterFallItem view = (FrsWaterFallItem) mInflater.inflate(R.layout.water_fall_item, (ViewGroup) null);
                            ImageView image = (ImageView) view.findViewById(R.id.image);
                            ViewGroup.LayoutParams params = image.getLayoutParams();
                            params.height = height;
                            image.setLayoutParams(params);
                            view.setTag(item);
                            image.setTag(item.getImage().getId());
                            view.setOnClickListener(this.mItemOnClickListener);
                            int padding = UtilHelper.dip2px(this, 5.0f);
                            int height2 = height + this.mItemTitleHeight + this.mItemNameHeight + (padding * 3) + view.getPaddingBottom();
                            view.setSize(this.mItemTitleHeight, this.mItemNameHeight, padding);
                            this.mWaterFallView.addItem(view, height2);
                            item.getImage().setImageDisplayHeight(height2);
                            item.getImage().setImageDisplayWidth(width);
                        }
                    }
                }
                addHeader();
            } catch (Exception e) {
                TiebaLog.e(getClass().getName(), "setData", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GetListTask extends AsyncTask<Object, Integer, FrsWaterFallModel> {
        private NetWork mNetWork = null;
        private int mStart;

        public GetListTask(int start) {
            this.mStart = 0;
            this.mStart = start;
            if (this.mStart < 1) {
                this.mStart = 1;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public FrsWaterFallModel doInBackground(Object... arg0) {
            FrsWaterFallModel model = null;
            try {
                this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/f/frs/photolist");
                if (FrsImageActivity.this.mFrom != null) {
                    this.mNetWork.addPostData(FrsImageActivity.URL_ST_TYPE, FrsImageActivity.this.mFrom);
                }
                this.mNetWork.addPostData("kw", FrsImageActivity.this.mForumName);
                this.mNetWork.addPostData("bs", String.valueOf(this.mStart));
                this.mNetWork.addPostData("be", String.valueOf((this.mStart + Config.FRS_WATER_FALL_PAGE_NUM) - 1));
                this.mNetWork.addPostData("an", String.valueOf(30));
                String ret = this.mNetWork.postNetData();
                if (!this.mNetWork.isRequestSuccess()) {
                    return null;
                }
                FrsWaterFallModel model2 = new FrsWaterFallModel();
                try {
                    model2.parserJson(ret);
                    if (FrsImageActivity.this.mAddSearch == 1) {
                        DatabaseService.saveOneSearchData(model2.getForum().getName());
                        return model2;
                    }
                    return model2;
                } catch (Exception e) {
                    e = e;
                    model = model2;
                    TiebaLog.e(getClass().getName(), "doInBackground", e.getMessage());
                    return model;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(FrsWaterFallModel result) {
            super.onPostExecute((GetListTask) result);
            FrsImageActivity.this.mListTask = null;
            FrsImageActivity.this.mProgressBar.setVisibility(8);
            if (result != null) {
                FrsImageActivity.this.mModel = result;
                FrsImageActivity.this.mWaterFallView.removeAllItems();
                FrsImageActivity.this.setData(result.getThread());
                FrsImageActivity.this.mCurrentIndex = 30;
                if (FrsImageActivity.this.mModel.getIdList().size() > 30) {
                    FrsImageActivity.this.setFooter(FooterType.NORMAL);
                } else if (this.mStart != 1 || FrsImageActivity.this.mModel.getIdList().size() != 0) {
                    FrsImageActivity.this.setFooter(FooterType.LAST);
                } else {
                    FrsImageActivity.this.setFooter(FooterType.NO_ITEM);
                }
                FrsImageActivity.this.mWaterFallView.scrollTo(0, 0);
                FrsImageActivity.this.mCurrentPage = this.mStart;
                if (FrsImageActivity.this.mCurrentPage > 1) {
                    FrsImageActivity.this.addPrePage();
                } else {
                    FrsImageActivity.this.removePrePage();
                }
                if (FrsImageActivity.this.mAddSearch == 1) {
                    FrsImageActivity.this.mAddSearch = 0;
                    FrsImageActivity.this.getIntent().putExtra(FrsImageActivity.ADD_SEARCH, 0);
                }
            } else if (this.mNetWork != null) {
                FrsImageActivity.this.showToast(this.mNetWork.getErrorString());
                if (this.mNetWork.isNetSuccess() && this.mNetWork.getErrorCode() == 2000) {
                    TiebaApplication.app.delFrsImageForum(FrsImageActivity.this.mForumName);
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FrsImageActivity.this.mProgressBar.setVisibility(0);
        }

        public void cancel() {
            FrsImageActivity.this.mListTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            FrsImageActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PullListTask extends AsyncTask<Object, Integer, FrsWaterFallModel> {
        private NetWork mNetWork = null;
        private int mStart;

        public PullListTask(int start) {
            this.mStart = 0;
            this.mStart = start;
            if (this.mStart < 0) {
                this.mStart = 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public FrsWaterFallModel doInBackground(Object... arg0) {
            FrsWaterFallModel model = null;
            try {
                this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/f/frs/photo");
                StringBuilder builder = new StringBuilder();
                int size = FrsImageActivity.this.mModel.getIdList().size();
                for (int i = this.mStart; i < size && i < this.mStart + 30; i++) {
                    builder.append(FrsImageActivity.this.mModel.getIdList().get(i));
                    builder.append(",");
                }
                int len = builder.length();
                if (len > 1 && builder.charAt(len - 1) == ',') {
                    builder.deleteCharAt(len - 1);
                }
                this.mNetWork.addPostData("alb_ids", builder.toString());
                this.mNetWork.addPostData("kw", FrsImageActivity.this.mForumName);
                String ret = this.mNetWork.postNetData();
                if (!this.mNetWork.isRequestSuccess()) {
                    return null;
                }
                FrsWaterFallModel model2 = new FrsWaterFallModel();
                try {
                    model2.parserJson(ret);
                    return model2;
                } catch (Exception e) {
                    e = e;
                    model = model2;
                    TiebaLog.e(getClass().getName(), "doInBackground", e.getMessage());
                    return model;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(FrsWaterFallModel result) {
            super.onPostExecute((PullListTask) result);
            FrsImageActivity.this.mPullListTask = null;
            FrsImageActivity.this.setFooter(FooterType.NORMAL);
            if (result == null) {
                if (this.mNetWork != null) {
                    FrsImageActivity.this.showToast(this.mNetWork.getErrorString());
                    return;
                }
                return;
            }
            FrsImageActivity.this.mCurrentIndex += 30;
            FrsImageActivity.this.setData(result.getThread());
            if (FrsImageActivity.this.mCurrentIndex >= FrsImageActivity.this.mModel.getIdList().size()) {
                if (FrsImageActivity.this.mModel.getHasMore() == 0) {
                    FrsImageActivity.this.setFooter(FooterType.LAST);
                } else {
                    FrsImageActivity.this.setFooter(FooterType.NEXT);
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            FrsImageActivity.this.setFooter(FooterType.LOADING);
        }

        public void cancel() {
            FrsImageActivity.this.mPullListTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            FrsImageActivity.this.setFooter(FooterType.NORMAL);
            super.cancel(true);
        }
    }
}
