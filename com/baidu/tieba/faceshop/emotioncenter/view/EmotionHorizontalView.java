package com.baidu.tieba.faceshop.emotioncenter.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.voice.h;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.NewFaceGroupDownloadModel;
import com.baidu.tieba.newfaceshop.a.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class EmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    private TextView iUa;
    private TextView iUb;
    private NewFaceGroupDownloadModel iUr;
    private EmotionPackageData iYv;
    private HListView iZq;
    private TextView iZr;
    private a iZs;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private View mTopLine;

    public EmotionHorizontalView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.emotion_grid_item_layout, this);
        this.iZq = (HListView) findViewById(R.id.emotion_item_grid);
        this.mTitle = (TextView) findViewById(R.id.emotion_title_tv);
        this.iUa = (TextView) findViewById(R.id.emotion_download_num_tv);
        this.iUb = (TextView) findViewById(R.id.emotion_share_num_tv);
        this.iZr = (TextView) findViewById(R.id.emotion_download_tv);
        this.mTopLine = findViewById(R.id.line);
        this.iZr.setOnClickListener(this);
        setOnClickListener(this);
        this.iZq.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iZq.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (EmotionHorizontalView.this.iYv != null) {
                    EmotionHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionHorizontalView.this.mPageContext.getPageActivity(), EmotionHorizontalView.this.iYv.id, 0)));
                }
            }
        });
        this.iZq.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.iZs = new a(this.mPageContext);
        this.iZq.setAdapter((ListAdapter) this.iZs);
    }

    public void onChangeSkin(int i) {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.iUa, R.color.CAM_X0109);
        ap.setViewTextColor(this.iUb, R.color.CAM_X0109);
        ap.setViewTextColor(this.iZr, R.color.CAM_X0109);
        ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
    }

    public void setData(EmotionPackageData emotionPackageData) {
        this.iYv = emotionPackageData;
        if (this.iYv != null) {
            this.iZq.setAdapter((ListAdapter) this.iZs);
            this.iZs.setData(this.iYv.pics, this.iYv.forum_id > 0);
            if (!TextUtils.isEmpty(this.iYv.forum_name)) {
                this.mTitle.setText(this.iYv.forum_name + "·" + this.iYv.name);
            } else {
                this.mTitle.setText(this.iYv.name);
            }
            this.iUa.setText(String.format(h.getString(R.string.package_detail_download_num), au.numberUniform(this.iYv.download)));
            this.iUb.setText(String.format(h.getString(R.string.package_detail_share_num), au.numberUniform(this.iYv.share)));
            if (com.baidu.tieba.faceshop.a.cyv().Jw("" + this.iYv.id)) {
                this.iZr.setText(R.string.already_downloaded);
                this.iZr.setBackgroundDrawable(null);
                ap.setViewTextColor(this.iZr, R.color.CAM_X0109);
                this.iZr.setBackgroundDrawable(null);
                this.iZr.setEnabled(false);
                return;
            }
            switch (this.iYv.status) {
                case 0:
                case 3:
                    this.iZr.setText(R.string.download);
                    ap.setViewTextColor(this.iZr, R.color.CAM_X0302);
                    ap.setBackgroundResource(this.iZr, R.drawable.bg_emotion_download);
                    this.iZr.setEnabled(true);
                    return;
                case 1:
                    this.iZr.setText(R.string.download);
                    ap.setViewTextColor(this.iZr, R.color.CAM_X0302);
                    ap.setBackgroundResource(this.iZr, R.drawable.bg_emotion_download);
                    this.iZr.setEnabled(true);
                    return;
                case 2:
                    this.iZr.setBackgroundDrawable(null);
                    ap.setViewTextColor(this.iZr, R.color.CAM_X0109);
                    this.iZr.setEnabled(false);
                    return;
                case 4:
                    this.iZr.setBackgroundDrawable(null);
                    ap.setViewTextColor(this.iZr, R.color.CAM_X0109);
                    this.iZr.setText(R.string.face_package_has_delete);
                    this.iZr.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iYv != null) {
            if (view == this.iZr) {
                cyI();
            } else if (view == this) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iYv.id, 0)));
            } else {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iYv.id, 0)));
            }
        }
    }

    private void cyI() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.iYv != null && this.iYv.id >= 0) {
            if (this.iUr == null) {
                this.iUr = new NewFaceGroupDownloadModel();
            }
            this.iZr.setEnabled(false);
            this.iUr.a(Integer.toString(this.iYv.id), true, new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView.2
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    l.showToast(EmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                    EmotionHorizontalView.this.iZr.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionHorizontalView.this.iZr, R.color.CAM_X0109);
                    EmotionHorizontalView.this.iZr.setBackgroundDrawable(null);
                    EmotionHorizontalView.this.iZr.setEnabled(false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onProgress(int i) {
                    if (i > 0 && i < 100) {
                        l.showLongToast(EmotionHorizontalView.this.mPageContext.getPageActivity(), h.getString(R.string.package_downloading_progress));
                    } else if (i >= 100) {
                        l.showLongToast(EmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                    }
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onFail(String str) {
                    l.showToast(EmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.download_error);
                    EmotionHorizontalView.this.iZr.setEnabled(true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eUY;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private boolean iZu = false;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eUY = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (!y.isEmpty(list)) {
                this.iZu = z;
                if (list.size() > 8) {
                    this.mDatas = list.subList(0, 8);
                    this.showCover = true;
                } else {
                    this.mDatas = list;
                    this.showCover = false;
                }
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mDatas == null) {
                return 0;
            }
            return this.mDatas.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.mDatas == null) {
                return null;
            }
            return this.mDatas.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0718a c0718a;
            if (view == null) {
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0718a c0718a2 = new C0718a(view);
                view.setTag(c0718a2);
                c0718a = c0718a2;
            } else {
                c0718a = (C0718a) view.getTag();
            }
            c0718a.a(this.mDatas.get(i), i == 0 && this.iZu, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0718a {
            private TextView ajF;
            private TbImageView iZv;
            private View iZw;
            private View mView;

            public C0718a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iZv = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.ajF = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iZw = this.mView.findViewById(R.id.emotion_cover_view);
                this.iZw.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iZv.setDefaultResource(R.drawable.img_default_100);
                        this.iZv.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (z) {
                        this.ajF.setVisibility(0);
                    } else {
                        this.ajF.setVisibility(8);
                    }
                    if (i == 7 && z2) {
                        this.iZw.setVisibility(0);
                    } else {
                        this.iZw.setVisibility(8);
                    }
                }
            }
        }
    }
}
