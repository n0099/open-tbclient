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
/* loaded from: classes8.dex */
public class EmotionHorizontalView extends LinearLayout implements View.OnClickListener {
    private TextView iVJ;
    private TextView iVK;
    private NewFaceGroupDownloadModel iWa;
    private HListView jaZ;
    private EmotionPackageData jae;
    private TextView jba;
    private a jbb;
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
        this.jaZ = (HListView) findViewById(R.id.emotion_item_grid);
        this.mTitle = (TextView) findViewById(R.id.emotion_title_tv);
        this.iVJ = (TextView) findViewById(R.id.emotion_download_num_tv);
        this.iVK = (TextView) findViewById(R.id.emotion_share_num_tv);
        this.jba = (TextView) findViewById(R.id.emotion_download_tv);
        this.mTopLine = findViewById(R.id.line);
        this.jba.setOnClickListener(this);
        setOnClickListener(this);
        this.jaZ.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds20));
        this.jaZ.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView.1
            @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                if (EmotionHorizontalView.this.jae != null) {
                    EmotionHorizontalView.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionHorizontalView.this.mPageContext.getPageActivity(), EmotionHorizontalView.this.jae.id, 0)));
                }
            }
        });
        this.jaZ.setSelector(this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg));
        this.jbb = new a(this.mPageContext);
        this.jaZ.setAdapter((ListAdapter) this.jbb);
    }

    public void onChangeSkin(int i) {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.iVJ, R.color.CAM_X0109);
        ap.setViewTextColor(this.iVK, R.color.CAM_X0109);
        ap.setViewTextColor(this.jba, R.color.CAM_X0109);
        ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
    }

    public void setData(EmotionPackageData emotionPackageData) {
        this.jae = emotionPackageData;
        if (this.jae != null) {
            this.jaZ.setAdapter((ListAdapter) this.jbb);
            this.jbb.setData(this.jae.pics, this.jae.forum_id > 0);
            if (!TextUtils.isEmpty(this.jae.forum_name)) {
                this.mTitle.setText(this.jae.forum_name + "·" + this.jae.name);
            } else {
                this.mTitle.setText(this.jae.name);
            }
            this.iVJ.setText(String.format(h.getString(R.string.package_detail_download_num), au.numberUniform(this.jae.download)));
            this.iVK.setText(String.format(h.getString(R.string.package_detail_share_num), au.numberUniform(this.jae.share)));
            if (com.baidu.tieba.faceshop.a.cyB().JF("" + this.jae.id)) {
                this.jba.setText(R.string.already_downloaded);
                this.jba.setBackgroundDrawable(null);
                ap.setViewTextColor(this.jba, R.color.CAM_X0109);
                this.jba.setBackgroundDrawable(null);
                this.jba.setEnabled(false);
                return;
            }
            switch (this.jae.status) {
                case 0:
                case 3:
                    this.jba.setText(R.string.download);
                    ap.setViewTextColor(this.jba, R.color.CAM_X0302);
                    ap.setBackgroundResource(this.jba, R.drawable.bg_emotion_download);
                    this.jba.setEnabled(true);
                    return;
                case 1:
                    this.jba.setText(R.string.download);
                    ap.setViewTextColor(this.jba, R.color.CAM_X0302);
                    ap.setBackgroundResource(this.jba, R.drawable.bg_emotion_download);
                    this.jba.setEnabled(true);
                    return;
                case 2:
                    this.jba.setBackgroundDrawable(null);
                    ap.setViewTextColor(this.jba, R.color.CAM_X0109);
                    this.jba.setEnabled(false);
                    return;
                case 4:
                    this.jba.setBackgroundDrawable(null);
                    ap.setViewTextColor(this.jba, R.color.CAM_X0109);
                    this.jba.setText(R.string.face_package_has_delete);
                    this.jba.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jae != null) {
            if (view == this.jba) {
                cyO();
            } else if (view == this) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.jae.id, 0)));
            } else {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(this.mPageContext.getPageActivity(), this.jae.id, 0)));
            }
        }
    }

    private void cyO() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity()) && this.jae != null && this.jae.id >= 0) {
            if (this.iWa == null) {
                this.iWa = new NewFaceGroupDownloadModel();
            }
            this.jba.setEnabled(false);
            this.iWa.a(Integer.toString(this.jae.id), true, new b() { // from class: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView.2
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    l.showToast(EmotionHorizontalView.this.mPageContext.getPageActivity(), R.string.down_state_success);
                    EmotionHorizontalView.this.jba.setText(R.string.already_downloaded);
                    ap.setViewTextColor(EmotionHorizontalView.this.jba, R.color.CAM_X0109);
                    EmotionHorizontalView.this.jba.setBackgroundDrawable(null);
                    EmotionHorizontalView.this.jba.setEnabled(false);
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
                    EmotionHorizontalView.this.jba.setEnabled(true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends BaseAdapter {
        private TbPageContext eWx;
        private List<EmotionPackageData.SingleEmotionData> mDatas = new ArrayList();
        private boolean jbd = false;
        private boolean showCover = false;

        public a(TbPageContext tbPageContext) {
            this.eWx = tbPageContext;
        }

        public void setData(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            if (!y.isEmpty(list)) {
                this.jbd = z;
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
            C0724a c0724a;
            if (view == null) {
                view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.emotion_item_layout, (ViewGroup) null);
                C0724a c0724a2 = new C0724a(view);
                view.setTag(c0724a2);
                c0724a = c0724a2;
            } else {
                c0724a = (C0724a) view.getTag();
            }
            c0724a.a(this.mDatas.get(i), i == 0 && this.jbd, this.showCover, i);
            return view;
        }

        /* renamed from: com.baidu.tieba.faceshop.emotioncenter.view.EmotionHorizontalView$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        static class C0724a {
            private TextView akX;
            private TbImageView jbe;
            private View jbf;
            private View mView;

            public C0724a(View view) {
                this.mView = view;
                this.mView.setEnabled(false);
                this.jbe = (TbImageView) this.mView.findViewById(R.id.emotion_img);
                this.akX = (TextView) this.mView.findViewById(R.id.emotion_single_bar_icon);
                this.jbf = this.mView.findViewById(R.id.emotion_cover_view);
                this.jbf.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                if (singleEmotionData != null) {
                    if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                        this.jbe.setDefaultResource(R.drawable.img_default_100);
                        this.jbe.startLoad(singleEmotionData.thumbnail, 10, false);
                    }
                    if (z) {
                        this.akX.setVisibility(0);
                    } else {
                        this.akX.setVisibility(8);
                    }
                    if (i == 7 && z2) {
                        this.jbf.setVisibility(0);
                    } else {
                        this.jbf.setVisibility(8);
                    }
                }
            }
        }
    }
}
