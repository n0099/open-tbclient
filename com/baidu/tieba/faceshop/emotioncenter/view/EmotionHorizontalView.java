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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
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
    private TextView iSM;
    private TextView iSN;
    private NewFaceGroupDownloadModel iTd;
    private EmotionPackageData iXh;
    private HListView iYc;
    private TextView iYd;
    private a iYe;
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
        this.iYc = (HListView) findViewById(R.id.emotion_item_grid);
        this.mTitle = (TextView) findViewById(R.id.emotion_title_tv);
        this.iSM = (TextView) findViewById(R.id.emotion_download_num_tv);
        this.iSN = (TextView) findViewById(R.id.emotion_share_num_tv);
        this.iYd = (TextView) findViewById(R.id.emotion_download_tv);
        this.mTopLine = findViewById(R.id.line);
        this.iYd.setOnClickListener(this);
        setOnClickListener(this);
        this.iYc.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iYc.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (EmotionHorizontalView.this.iXh != null) {
                    EmotionHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionHorizontalView.this.mPageContext.getPageActivity(), EmotionHorizontalView.this.iXh.id, 0)));
                }
            }
        });
        this.iYc.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.iYe = new a(this.mPageContext);
        this.iYc.setAdapter((ListAdapter) this.iYe);
    }

    public void onChangeSkin(int i) {
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(this.iSM, R.color.CAM_X0109);
        ao.setViewTextColor(this.iSN, R.color.CAM_X0109);
        ao.setViewTextColor(this.iYd, R.color.CAM_X0109);
        ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
    }

    public void setData(EmotionPackageData emotionPackageData) {
        this.iXh = emotionPackageData;
        if (this.iXh != null) {
            this.iYc.setAdapter((ListAdapter) this.iYe);
            this.iYe.setData(this.iXh.pics, this.iXh.forum_id > 0);
            if (!TextUtils.isEmpty(this.iXh.forum_name)) {
                this.mTitle.setText(this.iXh.forum_name + "·" + this.iXh.name);
            } else {
                this.mTitle.setText(this.iXh.name);
            }
            this.iSM.setText(String.format(h.getString(R.string.package_detail_download_num), at.numberUniform(this.iXh.download)));
            this.iSN.setText(String.format(h.getString(R.string.package_detail_share_num), at.numberUniform(this.iXh.share)));
            if (com.baidu.tieba.faceshop.a.cAV().JV("" + this.iXh.id)) {
                this.iYd.setText(R.string.already_downloaded);
                this.iYd.setBackgroundDrawable(null);
                ao.setViewTextColor(this.iYd, R.color.CAM_X0109);
                this.iYd.setBackgroundDrawable(null);
                this.iYd.setEnabled(false);
                return;
            }
            switch (this.iXh.status) {
                case 0:
                case 3:
                    this.iYd.setText(R.string.download);
                    ao.setViewTextColor(this.iYd, R.color.CAM_X0302);
                    ao.setBackgroundResource(this.iYd, R.drawable.bg_emotion_download);
                    this.iYd.setEnabled(true);
                    return;
                case 1:
                    this.iYd.setText(R.string.download);
                    ao.setViewTextColor(this.iYd, R.color.CAM_X0302);
                    ao.setBackgroundResource(this.iYd, R.drawable.bg_emotion_download);
                    this.iYd.setEnabled(true);
                    return;
                case 2:
                    this.iYd.setBackgroundDrawable(null);
                    ao.setViewTextColor(this.iYd, R.color.CAM_X0109);
                    this.iYd.setEnabled(false);
                    return;
                case 4:
                    this.iYd.setBackgroundDrawable(null);
                    ao.setViewTextColor(this.iYd, R.color.CAM_X0109);
                    this.iYd.setText(R.string.face_package_has_delete);
                    this.iYd.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iXh != null) {
            if (view == this.iYd) {
                cBi();
            } else if (view == this) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iXh.id, 0)));
            } else {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iXh.id, 0)));
            }
        }
    }

    private void cBi() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.iXh != null && this.iXh.id >= 0) {
            if (this.iTd == null) {
                this.iTd = new NewFaceGroupDownloadModel();
            }
            this.iYd.setEnabled(false);
            this.iTd.a(Integer.toString(this.iXh.id), true, new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView.2
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    l.showToast(EmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                    EmotionHorizontalView.this.iYd.setText(R.string.already_downloaded);
                    ao.setViewTextColor(EmotionHorizontalView.this.iYd, R.color.CAM_X0109);
                    EmotionHorizontalView.this.iYd.setBackgroundDrawable(null);
                    EmotionHorizontalView.this.iYd.setEnabled(false);
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
                    EmotionHorizontalView.this.iYd.setEnabled(true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eXu;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private boolean iYg = false;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eXu = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (!x.isEmpty(list)) {
                this.iYg = z;
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
            C0734a c0734a;
            if (view == null) {
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0734a c0734a2 = new C0734a(view);
                view.setTag(c0734a2);
                c0734a = c0734a2;
            } else {
                c0734a = (C0734a) view.getTag();
            }
            c0734a.a(this.mDatas.get(i), i == 0 && this.iYg, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0734a {
            private TextView akH;
            private TbImageView iYh;
            private View iYi;
            private View mView;

            public C0734a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iYh = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.akH = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iYi = this.mView.findViewById(R.id.emotion_cover_view);
                this.iYi.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iYh.setDefaultResource(R.drawable.img_default_100);
                        this.iYh.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (z) {
                        this.akH.setVisibility(0);
                    } else {
                        this.akH.setVisibility(8);
                    }
                    if (i == 7 && z2) {
                        this.iYi.setVisibility(0);
                    } else {
                        this.iYi.setVisibility(8);
                    }
                }
            }
        }
    }
}
