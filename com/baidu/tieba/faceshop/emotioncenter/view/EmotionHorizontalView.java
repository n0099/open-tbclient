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
/* loaded from: classes8.dex */
public class EmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    private TextView iOf;
    private TextView iOg;
    private NewFaceGroupDownloadModel iOw;
    private EmotionPackageData iSA;
    private HListView iTv;
    private TextView iTw;
    private a iTx;
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
        this.iTv = (HListView) findViewById(R.id.emotion_item_grid);
        this.mTitle = (TextView) findViewById(R.id.emotion_title_tv);
        this.iOf = (TextView) findViewById(R.id.emotion_download_num_tv);
        this.iOg = (TextView) findViewById(R.id.emotion_share_num_tv);
        this.iTw = (TextView) findViewById(R.id.emotion_download_tv);
        this.mTopLine = findViewById(R.id.line);
        this.iTw.setOnClickListener(this);
        setOnClickListener(this);
        this.iTv.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iTv.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (EmotionHorizontalView.this.iSA != null) {
                    EmotionHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionHorizontalView.this.mPageContext.getPageActivity(), EmotionHorizontalView.this.iSA.id, 0)));
                }
            }
        });
        this.iTv.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.iTx = new a(this.mPageContext);
        this.iTv.setAdapter((ListAdapter) this.iTx);
    }

    public void onChangeSkin(int i) {
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(this.iOf, R.color.CAM_X0109);
        ao.setViewTextColor(this.iOg, R.color.CAM_X0109);
        ao.setViewTextColor(this.iTw, R.color.CAM_X0109);
        ao.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
    }

    public void setData(EmotionPackageData emotionPackageData) {
        this.iSA = emotionPackageData;
        if (this.iSA != null) {
            this.iTv.setAdapter((ListAdapter) this.iTx);
            this.iTx.setData(this.iSA.pics, this.iSA.forum_id > 0);
            if (!TextUtils.isEmpty(this.iSA.forum_name)) {
                this.mTitle.setText(this.iSA.forum_name + "·" + this.iSA.name);
            } else {
                this.mTitle.setText(this.iSA.name);
            }
            this.iOf.setText(String.format(h.getString(R.string.package_detail_download_num), at.numberUniform(this.iSA.download)));
            this.iOg.setText(String.format(h.getString(R.string.package_detail_share_num), at.numberUniform(this.iSA.share)));
            if (com.baidu.tieba.faceshop.a.cxd().IK("" + this.iSA.id)) {
                this.iTw.setText(R.string.already_downloaded);
                this.iTw.setBackgroundDrawable(null);
                ao.setViewTextColor(this.iTw, R.color.CAM_X0109);
                this.iTw.setBackgroundDrawable(null);
                this.iTw.setEnabled(false);
                return;
            }
            switch (this.iSA.status) {
                case 0:
                case 3:
                    this.iTw.setText(R.string.download);
                    ao.setViewTextColor(this.iTw, R.color.CAM_X0302);
                    ao.setBackgroundResource(this.iTw, R.drawable.bg_emotion_download);
                    this.iTw.setEnabled(true);
                    return;
                case 1:
                    this.iTw.setText(R.string.download);
                    ao.setViewTextColor(this.iTw, R.color.CAM_X0302);
                    ao.setBackgroundResource(this.iTw, R.drawable.bg_emotion_download);
                    this.iTw.setEnabled(true);
                    return;
                case 2:
                    this.iTw.setBackgroundDrawable(null);
                    ao.setViewTextColor(this.iTw, R.color.CAM_X0109);
                    this.iTw.setEnabled(false);
                    return;
                case 4:
                    this.iTw.setBackgroundDrawable(null);
                    ao.setViewTextColor(this.iTw, R.color.CAM_X0109);
                    this.iTw.setText(R.string.face_package_has_delete);
                    this.iTw.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iSA != null) {
            if (view == this.iTw) {
                cxq();
            } else if (view == this) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iSA.id, 0)));
            } else {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iSA.id, 0)));
            }
        }
    }

    private void cxq() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.iSA != null && this.iSA.id >= 0) {
            if (this.iOw == null) {
                this.iOw = new NewFaceGroupDownloadModel();
            }
            this.iTw.setEnabled(false);
            this.iOw.a(Integer.toString(this.iSA.id), true, new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView.2
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    l.showToast(EmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                    EmotionHorizontalView.this.iTw.setText(R.string.already_downloaded);
                    ao.setViewTextColor(EmotionHorizontalView.this.iTw, R.color.CAM_X0109);
                    EmotionHorizontalView.this.iTw.setBackgroundDrawable(null);
                    EmotionHorizontalView.this.iTw.setEnabled(false);
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
                    EmotionHorizontalView.this.iTw.setEnabled(true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eSJ;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private boolean iTz = false;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eSJ = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (!x.isEmpty(list)) {
                this.iTz = z;
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
            C0717a c0717a;
            if (view == null) {
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0717a c0717a2 = new C0717a(view);
                view.setTag(c0717a2);
                c0717a = c0717a2;
            } else {
                c0717a = (C0717a) view.getTag();
            }
            c0717a.a(this.mDatas.get(i), i == 0 && this.iTz, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        static class C0717a {
            private TextView ajQ;
            private TbImageView iTA;
            private View iTB;
            private View mView;

            public C0717a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iTA = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.ajQ = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iTB = this.mView.findViewById(R.id.emotion_cover_view);
                this.iTB.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iTA.setDefaultResource(R.drawable.img_default_100);
                        this.iTA.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (z) {
                        this.ajQ.setVisibility(0);
                    } else {
                        this.ajQ.setVisibility(8);
                    }
                    if (i == 7 && z2) {
                        this.iTB.setVisibility(0);
                    } else {
                        this.iTB.setVisibility(8);
                    }
                }
            }
        }
    }
}
