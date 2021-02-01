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
    private TextView iTM;
    private TextView iTN;
    private NewFaceGroupDownloadModel iUd;
    private EmotionPackageData iYh;
    private HListView iZc;
    private TextView iZd;
    private a iZe;
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
        this.iZc = (HListView) findViewById(R.id.emotion_item_grid);
        this.mTitle = (TextView) findViewById(R.id.emotion_title_tv);
        this.iTM = (TextView) findViewById(R.id.emotion_download_num_tv);
        this.iTN = (TextView) findViewById(R.id.emotion_share_num_tv);
        this.iZd = (TextView) findViewById(R.id.emotion_download_tv);
        this.mTopLine = findViewById(R.id.line);
        this.iZd.setOnClickListener(this);
        setOnClickListener(this);
        this.iZc.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iZc.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (EmotionHorizontalView.this.iYh != null) {
                    EmotionHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionHorizontalView.this.mPageContext.getPageActivity(), EmotionHorizontalView.this.iYh.id, 0)));
                }
            }
        });
        this.iZc.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.iZe = new a(this.mPageContext);
        this.iZc.setAdapter((ListAdapter) this.iZe);
    }

    public void onChangeSkin(int i) {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.iTM, R.color.CAM_X0109);
        ap.setViewTextColor(this.iTN, R.color.CAM_X0109);
        ap.setViewTextColor(this.iZd, R.color.CAM_X0109);
        ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
    }

    public void setData(EmotionPackageData emotionPackageData) {
        this.iYh = emotionPackageData;
        if (this.iYh != null) {
            this.iZc.setAdapter((ListAdapter) this.iZe);
            this.iZe.setData(this.iYh.pics, this.iYh.forum_id > 0);
            if (!TextUtils.isEmpty(this.iYh.forum_name)) {
                this.mTitle.setText(this.iYh.forum_name + "·" + this.iYh.name);
            } else {
                this.mTitle.setText(this.iYh.name);
            }
            this.iTM.setText(String.format(h.getString(R.string.package_detail_download_num), au.numberUniform(this.iYh.download)));
            this.iTN.setText(String.format(h.getString(R.string.package_detail_share_num), au.numberUniform(this.iYh.share)));
            if (com.baidu.tieba.faceshop.a.cyo().Jv("" + this.iYh.id)) {
                this.iZd.setText(R.string.already_downloaded);
                this.iZd.setBackgroundDrawable(null);
                ap.setViewTextColor(this.iZd, R.color.CAM_X0109);
                this.iZd.setBackgroundDrawable(null);
                this.iZd.setEnabled(false);
                return;
            }
            switch (this.iYh.status) {
                case 0:
                case 3:
                    this.iZd.setText(R.string.download);
                    ap.setViewTextColor(this.iZd, R.color.CAM_X0302);
                    ap.setBackgroundResource(this.iZd, R.drawable.bg_emotion_download);
                    this.iZd.setEnabled(true);
                    return;
                case 1:
                    this.iZd.setText(R.string.download);
                    ap.setViewTextColor(this.iZd, R.color.CAM_X0302);
                    ap.setBackgroundResource(this.iZd, R.drawable.bg_emotion_download);
                    this.iZd.setEnabled(true);
                    return;
                case 2:
                    this.iZd.setBackgroundDrawable(null);
                    ap.setViewTextColor(this.iZd, R.color.CAM_X0109);
                    this.iZd.setEnabled(false);
                    return;
                case 4:
                    this.iZd.setBackgroundDrawable(null);
                    ap.setViewTextColor(this.iZd, R.color.CAM_X0109);
                    this.iZd.setText(R.string.face_package_has_delete);
                    this.iZd.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iYh != null) {
            if (view == this.iZd) {
                cyB();
            } else if (view == this) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iYh.id, 0)));
            } else {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.iYh.id, 0)));
            }
        }
    }

    private void cyB() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.iYh != null && this.iYh.id >= 0) {
            if (this.iUd == null) {
                this.iUd = new NewFaceGroupDownloadModel();
            }
            this.iZd.setEnabled(false);
            this.iUd.a(Integer.toString(this.iYh.id), true, new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView.2
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    l.showToast(EmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                    EmotionHorizontalView.this.iZd.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionHorizontalView.this.iZd, R.color.CAM_X0109);
                    EmotionHorizontalView.this.iZd.setBackgroundDrawable(null);
                    EmotionHorizontalView.this.iZd.setEnabled(false);
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
                    EmotionHorizontalView.this.iZd.setEnabled(true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eUY;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private boolean iZg = false;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eUY = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (!y.isEmpty(list)) {
                this.iZg = z;
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
                view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0717a c0717a2 = new C0717a(view);
                view.setTag(c0717a2);
                c0717a = c0717a2;
            } else {
                c0717a = (C0717a) view.getTag();
            }
            c0717a.a(this.mDatas.get(i), i == 0 && this.iZg, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0717a {
            private TextView ajF;
            private TbImageView iZh;
            private View iZi;
            private View mView;

            public C0717a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.iZh = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.ajF = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.iZi = this.mView.findViewById(R.id.emotion_cover_view);
                this.iZi.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.iZh.setDefaultResource(R.drawable.img_default_100);
                        this.iZh.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (z) {
                        this.ajF.setVisibility(0);
                    } else {
                        this.ajF.setVisibility(8);
                    }
                    if (i == 7 && z2) {
                        this.iZi.setVisibility(0);
                    } else {
                        this.iZi.setVisibility(8);
                    }
                }
            }
        }
    }
}
