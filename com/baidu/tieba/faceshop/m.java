package com.baidu.tieba.faceshop;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.compatible.menukey.MenuKeyUtils;
import java.util.LinkedList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class m {
    private TextView bNG;
    private int cDn;
    private final TextView fCA;
    private final TextView fkS;
    private final TbImageView gGY;
    private final NoNetworkView gzT;
    private int iHA;
    private int iHB;
    private WindowManager.LayoutParams iHx;
    private GifView iHy;
    private final TbPageContext<l> iWY;
    private final NavigationBar iWZ;
    private final TextView iXa;
    private final TextView iXb;
    private final FrameLayout iXc;
    private final ImageView iXd;
    private final ImageView iXe;
    private TextView iXf;
    private final int iXg;
    private final int iXh;
    private final int iXi;
    private final GridView iXj;
    private n iXk;
    private final j iXl;
    private boolean iXm;
    private boolean iXn;
    private final ScrollView iXo;
    private final TbImageView iXq;
    private final LinearLayout mContainer;
    private final Handler mHandler;
    private int mHeight;
    private final View mParent;
    private final int mSkinType;
    private final TextView mTitle;
    private int mWidth;
    private WindowManager mWindowManager;
    private int iXp = -1;
    private final Runnable iXr = new Runnable() { // from class: com.baidu.tieba.faceshop.m.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                m.this.Xt();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    };

    public m(TbPageContext<l> tbPageContext) {
        this.iWY = tbPageContext;
        tbPageContext.getOrignalPage().setContentView(R.layout.face_package_detail_activity);
        this.mParent = tbPageContext.getPageActivity().findViewById(R.id.face_package);
        this.iWZ = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iWZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bNG = this.iWZ.setTitleText("");
        this.gzT = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.mContainer = (LinearLayout) this.mParent.findViewById(R.id.face_package_container);
        this.iXf = (TextView) this.mParent.findViewById(R.id.top_view);
        ((LinearLayout.LayoutParams) this.iXf.getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iWY.getPageActivity(), R.dimen.ds98);
        this.gGY = (TbImageView) this.mParent.findViewById(R.id.face_package_cover);
        this.mTitle = (TextView) this.mParent.findViewById(R.id.face_package_title);
        this.fkS = (TextView) this.mParent.findViewById(R.id.face_package_price);
        this.iXa = (TextView) this.mParent.findViewById(R.id.face_package_status);
        this.fCA = (TextView) this.mParent.findViewById(R.id.face_package_btn);
        this.iXb = (TextView) this.mParent.findViewById(R.id.face_package_info);
        this.iXj = (GridView) this.mParent.findViewById(R.id.face_package_faces);
        this.iXq = (TbImageView) this.mParent.findViewById(R.id.face_package_title_tag);
        this.iXq.setDefaultResource(0);
        this.iXq.setDefaultBgResource(0);
        this.iXj.setSelection(-1);
        try {
            this.iXj.setOnItemLongClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.iXj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.m.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                m.this.iXj.setSelection(-1);
            }
        });
        this.iXc = (FrameLayout) this.mParent.findViewById(R.id.face_package_downloading);
        this.iXd = (ImageView) this.mParent.findViewById(R.id.face_package_downloading_up);
        this.iXe = (ImageView) this.mParent.findViewById(R.id.face_package_downloading_cancel);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        this.mWidth = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.mHeight = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.mHandler = new Handler();
        this.fCA.setOnClickListener(tbPageContext.getOrignalPage());
        this.iXe.setOnClickListener(tbPageContext.getOrignalPage());
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_down);
        Bitmap cashBitmap2 = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_up);
        this.iXh = cashBitmap.getWidth();
        this.iXg = cashBitmap2.getWidth();
        this.iXi = this.iWY.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.iXl = new j(this.iWY, R.style.common_alert_dialog);
        this.iXo = (ScrollView) this.mParent.findViewById(R.id.container_scrollview);
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.iHy = new GifView(tbPageContext.getPageActivity());
        ap.setBackgroundResource(this.iHy, R.drawable.bg_expression_bubble);
        this.iHy.setVisibility(8);
        this.iHy.setSupportNoImage(false);
        this.mWindowManager = (WindowManager) tbPageContext.getPageActivity().getSystemService("window");
        this.iHx = new WindowManager.LayoutParams();
        this.iHA = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds216);
        this.iHB = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.iHx.width = this.iHA;
        this.iHx.height = this.iHB;
        this.iHx.gravity = 51;
        this.iHx.format = -3;
        this.iHx.type = 1000;
        this.iHx.flags |= 56;
        this.cDn = com.baidu.adp.lib.util.l.getStatusBarHeight(tbPageContext.getPageActivity());
        if (MenuKeyUtils.hasSmartBar()) {
            this.iHx.type = 1000;
            this.iHx.flags = 25165832;
        }
    }

    public void g(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel != null) {
            h(facePackageDetailModel);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.face_list != null) {
            this.iXj.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.iWY.getPageActivity()) - (this.iXi * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
        }
    }

    public void JW(String str) {
        if (str != null && str.length() > 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(linkedList));
        }
    }

    public void c(FacePackageData facePackageData) {
        if (facePackageData != null) {
            if (this.iXk == null) {
                this.iXk = new n(this.iWY.getPageActivity(), facePackageData.face_list);
                this.iXj.setAdapter((ListAdapter) this.iXk);
                return;
            }
            this.iXk.setData(facePackageData.face_list);
            this.iXk.notifyDataSetChanged();
        }
    }

    public void h(FacePackageDetailModel facePackageDetailModel) {
        FacePackageData facePackageData;
        if (facePackageDetailModel != null && facePackageDetailModel.czc() != null && (facePackageData = facePackageDetailModel.czc().faces_list) != null) {
            if (facePackageDetailModel.cze()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.mContainer.setVisibility(0);
            this.gGY.setTag(facePackageData.cover_url);
            this.mTitle.setText(facePackageData.pname);
            this.iXq.setTag(facePackageData.tag_url);
            this.fkS.setText(this.iWY.getResources().getString(R.string.price_tip) + facePackageData.price);
            this.iXb.setText(facePackageData.pdesc);
            this.bNG.setText(facePackageData.pname);
            b(facePackageData);
            JW(facePackageDetailModel.getPid());
            c(facePackageData);
            czh();
        }
    }

    private void czh() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iXr);
            this.mHandler.postDelayed(this.iXr, 90L);
        }
    }

    public void Xt() {
        if (this.gGY != null && this.gGY.getTag() != null) {
            this.gGY.a(this.gGY.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
        if (this.iXq != null && this.iXq.getTag() != null) {
            this.iXq.a(this.iXq.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
    }

    public void qi(boolean z) {
        BdListViewHelper.a(this.iXf, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c(NoNetworkView.a aVar) {
        this.gzT.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gzT.b(aVar);
    }

    public void i(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel != null && facePackageDetailModel.czc() != null && facePackageDetailModel.czc().faces_list != null) {
            FacePackageData facePackageData = facePackageDetailModel.czc().faces_list;
            if (facePackageData.buy_status == 1) {
                this.iXa.setText(this.iWY.getResources().getString(R.string.has_buy));
                this.iXa.setVisibility(0);
            } else {
                this.iXa.setVisibility(8);
            }
            switch (facePackageDetailModel.czf()) {
                case 1:
                    czi();
                    return;
                case 2:
                case 3:
                    czk();
                    return;
                case 4:
                    czj();
                    return;
                case 5:
                    F(facePackageData.downloadTotal, facePackageData.downloadNow);
                    return;
                case 6:
                    czl();
                    return;
                default:
                    return;
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void czi() {
        this.fCA.setVisibility(0);
        this.iXc.setVisibility(8);
        this.fCA.setText(this.iWY.getResources().getString(R.string.downloaded));
        ap.setViewTextColor(this.fCA, R.color.common_color_10172, 1);
        ap.setBackgroundResource(this.fCA, R.drawable.btn_content_buy_d);
    }

    public void F(long j, long j2) {
        this.fCA.setVisibility(8);
        this.iXc.setVisibility(0);
        int i = (int) ((((float) j2) / ((float) j)) * this.iXh);
        int i2 = i < this.iXg ? this.iXg : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iXd.getLayoutParams();
        layoutParams.width = i2;
        this.iXd.setLayoutParams(layoutParams);
    }

    public void czj() {
        this.fCA.setVisibility(0);
        this.iXc.setVisibility(8);
        this.fCA.setText(this.iWY.getResources().getString(R.string.buy_book));
        ap.setBackgroundResource(this.fCA, R.drawable.btn_all_blue);
    }

    @SuppressLint({"ResourceAsColor"})
    public void czk() {
        this.fCA.setVisibility(0);
        this.iXc.setVisibility(8);
        this.fCA.setText(this.iWY.getResources().getString(R.string.can_download));
        ap.setViewTextColor(this.fCA, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.fCA, R.drawable.btn_all_blue);
    }

    private void czl() {
        this.fCA.setVisibility(0);
        this.iXc.setVisibility(8);
        this.fCA.setText(this.iWY.getResources().getString(R.string.off_the_shelf));
        ap.setViewTextColor(this.fCA, R.color.common_color_10172, 1);
        ap.setBackgroundResource(this.fCA, R.drawable.btn_content_buy_d);
    }

    public void czm() {
        if (this.iXl != null) {
            this.iXl.cyS();
            com.baidu.adp.lib.f.g.a(this.iXl, this.iWY);
        }
    }

    public void czn() {
        if (this.iXl != null) {
            this.iXl.cyT();
        }
    }

    public void czo() {
        if (this.iXl != null) {
            com.baidu.adp.lib.f.g.b(this.iXl, this.iWY);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iWY != null) {
            this.iWY.getLayoutMode().setNightMode(i == 1);
            this.iWY.getLayoutMode().onModeChanged(this.mParent);
        }
        if (this.iWZ != null) {
            this.iWZ.onChangeSkinType(this.iWY, i);
        }
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(this.iWY, i);
        }
    }

    public void czp() {
        if (this.gzT != null && this.gzT.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.gzT.update(false);
        }
    }

    public TextView czq() {
        return this.fCA;
    }

    public ImageView czr() {
        return this.iXe;
    }

    public void a(int i, Rect rect, FacePackageData facePackageData) {
        if (i != this.iXp && facePackageData.face_dynamic_list != null && i >= 0 && i <= facePackageData.face_dynamic_list.size()) {
            if (this.iXp != -1) {
                O(this.iXp, false);
            }
            this.iXp = i;
            this.iXj.setSelection(i);
            O(i, true);
            this.iXn = true;
            this.iHy.setVisibility(0);
            String str = "#(" + facePackageData.face_dynamic_list.get(i) + ")";
            this.iHy.setTag(str);
            if (com.baidu.tbadk.util.n.bFw()) {
                GifInfo gifInfo = new GifInfo();
                gifInfo.mGid = facePackageData.pid + "";
                gifInfo.mSharpText = str;
                gifInfo.mGifHeight = this.mHeight;
                gifInfo.mGifWidth = this.mWidth;
                gifInfo.mDynamicUrl = facePackageData.face_dynamic_list.get(i);
                this.iHy.a(gifInfo);
            } else {
                GifInfo gifInfo2 = new GifInfo();
                gifInfo2.mGid = facePackageData.pid + "";
                gifInfo2.mGifHeight = this.mHeight;
                gifInfo2.mGifWidth = this.mWidth;
                gifInfo2.mSharpText = str;
                gifInfo2.mStaticUrl = facePackageData.face_list.get(i);
                this.iHy.a(gifInfo2);
            }
            this.iHx.x = rect.left - ((this.iHA - rect.width()) / 2);
            this.iHx.y = rect.top - this.iHx.height;
            if (this.iHx.y < this.cDn) {
                this.iXo.scrollBy(0, this.iHx.y - this.cDn);
                this.iHx.y = this.cDn;
            }
            this.iHx.y += this.iXj.getChildAt(i - this.iXj.getFirstVisiblePosition()).getPaddingTop();
            if (!this.iXm) {
                this.mWindowManager.addView(this.iHy, this.iHx);
                this.iXm = true;
                return;
            }
            this.mWindowManager.updateViewLayout(this.iHy, this.iHx);
        }
    }

    public boolean czs() {
        return this.iXn;
    }

    public void czt() {
        this.iXn = false;
        this.iHy.setVisibility(8);
        this.iXj.setSelection(-1);
        O(this.iXp, false);
        this.iXp = -1;
    }

    private void O(int i, boolean z) {
        ((ViewGroup) this.iXj.getChildAt(i - this.iXj.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void czu() {
        this.iXn = false;
        if (this.iXm) {
            this.iXm = false;
            this.mWindowManager.removeView(this.iHy);
        }
    }

    public GridView czv() {
        return this.iXj;
    }
}
