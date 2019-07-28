package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private com.baidu.tbadk.editortools.pb.b ctL;
    private g djG;
    private NoNetworkView dnF;
    private PbListView dnG;
    private NoNetworkView.a eHh;
    private BdTypeRecyclerView fTq;
    private View fvL;
    private NewWriteModel.d gmA;
    private com.baidu.tieba.homepage.topic.topicdetail.a gmj;
    private ImageView gmk;
    private TopicDetailHeadView gml;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b gmm;
    private View gmn;
    private View gmo;
    private TextView gmp;
    private TextView gmq;
    private a gmr;
    private View gms;
    private com.baidu.tieba.write.b gmt;
    private EditText gmu;
    private int gmv;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a gmw;
    a.RunnableC0327a gmx;
    private int gmy;
    private int gmz;
    private ImageView mBackImageView;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private BdListView.e mOnScrollToBottomListener;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private int mSkinType;
    private com.baidu.tieba.homepage.topic.topicdetail.b.a mTopicDetailData;

    public TopicDetailView(TbPageContext<?> tbPageContext, com.baidu.tieba.homepage.topic.topicdetail.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gmo = null;
        this.gmp = null;
        this.gmq = null;
        this.mHasMore = true;
        this.gmy = 0;
        this.gmz = 44;
        this.eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.gmj != null) {
                    TopicDetailView.this.gmj.loadData();
                }
            }
        };
        this.ctL = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean asw() {
                if (TopicDetailView.this.gmt.czg()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.gmt.czi());
                    TopicDetailView.this.ly(true);
                    return true;
                }
                return false;
            }
        };
        this.gmA = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.gmr != null && TopicDetailView.this.gmr.arY() != null) {
                    TopicDetailView.this.gmr.arY().hide();
                }
                if (z) {
                    TopicDetailView.this.gmt.GA(null);
                    TopicDetailView.this.gmt.aI(null);
                    TopicDetailView.this.gmt.rZ(false);
                    if (postWriteCallBackData != null) {
                        long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                        long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                        if (c != 0 && c2 != 0) {
                            TopicDetailView.this.gmx = TopicDetailView.this.gmw.p(c, c2);
                            com.baidu.adp.lib.g.e.iK().postDelayed(TopicDetailView.this.gmx, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.gmt.aI(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.gmt.GA(postWriteCallBackData.getErrorString());
                    if (!v.aa(TopicDetailView.this.gmt.cze())) {
                        TopicDetailView.this.ly(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.gmr != null) {
                    TopicDetailView.this.gmr.asV();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fTq, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.gmy += i2;
                TopicDetailView.this.bxu();
            }
        };
        this.mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.kt()) {
                        TopicDetailView.this.aKk();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dr(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).glK);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gmj = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.fvL == null) {
            this.fvL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fvL.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.fvL.findViewById(R.id.widget_navi_back_button);
        }
        this.gmk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        am.c(this.gmk, (int) R.drawable.selector_topbar_share_white);
        am.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dnF = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.dnF.a(this.eHh);
        this.gmo = findViewById(R.id.pb_editor_tool_comment);
        this.gmp = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.gmp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bxt();
            }
        });
        this.gmq = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.gmn = findViewById(R.id.activity_topic_detail_editor);
        S(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.gmr.arY(), layoutParams);
        this.gmt = new com.baidu.tieba.write.b();
        this.gms = findViewById(R.id.activity_topic_detail_editor_top);
        this.fTq = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.fTq.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fTq.setFadingEdgeLength(0);
        this.fTq.setOverScrollMode(2);
        this.fTq.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fTq.addOnScrollListener(this.mScrollListener);
        am.l(this.fTq, R.color.cp_bg_line_d);
        this.gmm = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fTq);
        this.gml = new TopicDetailHeadView(getContext());
        this.gml.gmh.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void ui(int i) {
                TopicDetailView.this.uh(i);
            }
        });
        if (this.djG == null) {
            this.dnG = new PbListView(this.mPageContext.getPageActivity());
            this.dnG.getView();
        }
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.iT(R.color.cp_cont_e);
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_e));
        this.dnG.iU(am.getColor(R.color.cp_bg_line_d));
        this.dnG.iQ(am.getColor(R.color.cp_bg_line_c));
        this.dnG.setText(getResources().getString(R.string.list_has_no_more));
        this.dnG.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.gmw == null) {
            this.gmw = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.gmw.j(this.mPageContext.getUniqueId());
        }
    }

    private void S(Bundle bundle) {
        this.gmr = (a) new b().cK(getContext());
        if (this.gmr != null) {
            this.gmr.a(this.mPageContext);
            this.gmr.b(this.gmA);
            this.gmr.a(this.ctL);
            this.gmr.arY().fh(true);
            this.gmr.a((BaseActivity) getContext(), bundle);
            this.gmr.asV();
            this.gmr.arY().setId(R.id.topic_editor);
            this.gmu = this.gmr.bxs().getInputView();
            this.gmu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.gmt != null) {
                        if (!TopicDetailView.this.gmt.czh()) {
                            TopicDetailView.this.ly(false);
                        }
                        TopicDetailView.this.gmt.sa(false);
                    }
                }
            });
        }
    }

    public void ly(boolean z) {
        if (this.gmu != null && this.gmu.getText() != null) {
            int selectionEnd = this.gmu.getSelectionEnd();
            SpannableStringBuilder b = this.gmt.b(this.gmu.getText());
            if (b != null) {
                this.gmt.sa(true);
                this.gmu.setText(b);
                if (z && this.gmt.czf() >= 0) {
                    this.gmu.requestFocus();
                    this.gmu.setSelection(this.gmt.czf());
                } else {
                    this.gmu.setSelection(selectionEnd);
                }
                this.gmt.rZ(this.gmt.czf() >= 0);
            }
        }
    }

    public void bxt() {
        if (bd.cF(getContext())) {
            this.gmr.asY();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(int i) {
        this.gmv = i;
        this.gmq.setVisibility(0);
        if (i == 1) {
            this.gmq.setText(R.string.topic_detail_pk_support);
            am.k(this.gmq, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.gmq.setText(R.string.topic_detail_pk_oppose);
            am.k(this.gmq, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.gmq.setText(R.string.topic_detail_pk_chigua);
            am.k(this.gmq, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1) {
            this.gmq.setTextColor(-2130706433);
        } else {
            am.j(this.gmq, R.color.cp_btn_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int g;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aKj();
            } else if (!this.mHasMore) {
                aKj();
            } else {
                aKi();
            }
            if (!StringUtils.isNull(aVar.bID)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.j(aVar.bID, 14, "...")));
            }
            this.gml.setData(aVar.glC);
            this.fTq.addHeaderView(this.gml);
            this.gmm.setData(aVar.mDataList);
            if (this.mTopicDetailData.glC.glH != null) {
                if (this.mTopicDetailData.glC.glH.gnd.gnj) {
                    uh(1);
                } else if (this.mTopicDetailData.glC.glH.gne.gnj) {
                    uh(2);
                } else {
                    uh(0);
                }
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            } else {
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.gmq.setVisibility(8);
            }
            this.gmp.setPadding(g, 0, 0, 0);
            bxu();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aKj();
        } else {
            aKi();
        }
        if (i == 0 && list != null && !v.aa(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).glM = this.mTopicDetailData.bxn();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fTq.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKk() {
        this.fTq.setNextPage(null);
    }

    public void aKi() {
        this.mHasMore = true;
        this.fTq.setNextPage(this.dnG);
        this.dnG.akD();
    }

    public void aKj() {
        this.fTq.setNextPage(this.dnG);
        this.dnG.akE();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fvL) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gmk && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            akY();
            TiebaStatic.log(new an("c13364").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void akY() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.bID;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.glB) ? null : Uri.parse(this.mTopicDetailData.glB);
            final com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = str2;
            eVar.linkUrl = str3;
            eVar.cky = true;
            eVar.extData = valueOf;
            eVar.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), eVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.aS(eVar.linkUrl);
                    l.showToast(TopicDetailView.this.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.mPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            bxu();
            am.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
            am.k(this.gmo, R.color.cp_cont_g);
            am.j(this.gmp, R.color.cp_cont_d);
            am.k(this.gmp, R.drawable.topic_discuss_input_bg);
            uh(this.gmv);
            am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
            if (this.gmk != null) {
                am.c(this.gmk, (int) R.drawable.selector_topbar_share_white);
            }
            if (this.mPageContext != null && this.dnF != null) {
                this.dnF.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.djG != null) {
                this.djG.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gmr != null && this.gmr.arY() != null) {
                this.gmr.arY().onChangeSkinType(this.mSkinType);
            }
            if (this.dnG != null) {
                this.dnG.iT(R.color.cp_cont_e);
                this.dnG.setTextColor(am.getColor(R.color.cp_cont_e));
                this.dnG.iU(am.getColor(R.color.cp_bg_line_d));
                this.dnG.iQ(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.gml != null) {
                this.gml.onChangeSkinType();
            }
            if (this.gmm != null) {
                this.gmm.notifyDataSetChanged();
            }
            am.l(this.fTq, R.color.cp_bg_line_d);
        }
    }

    public void cY(boolean z) {
        if (!bgI()) {
            if (this.djG == null) {
                this.djG = new g(getContext());
                this.djG.onChangeSkinType();
            }
            this.djG.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.djG != null) {
            this.djG.dettachView(this);
            this.djG = null;
        }
    }

    public boolean bgI() {
        if (this.djG != null) {
            return this.djG.isViewAttached();
        }
        return false;
    }

    public void ju(boolean z) {
        if (!bgJ()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && TopicDetailView.this.gmj != null) {
                            TopicDetailView.this.gmj.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.kK(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atI();
            this.fTq.setVisibility(8);
            am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
        }
    }

    public void aJh() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fTq.setVisibility(0);
        am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
    }

    public boolean bgJ() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        this.fTq.setOnSrollToBottomListener(null);
        if (this.dnF != null) {
            this.dnF.b(this.eHh);
        }
        if (this.gmr != null) {
            this.gmr.onDestory();
        }
        if (this.gmx != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gmx);
        }
        hideLoadingView();
        aJh();
    }

    public a getEditor() {
        return this.gmr;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.gms != null) {
            ViewGroup.LayoutParams layoutParams = this.gms.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.gmr.arY().isVisible()) {
                    layoutParams2.addRule(2, this.gmr.arY().getId());
                } else {
                    layoutParams2.addRule(2, this.gmn.getId());
                }
                this.gms.setLayoutParams(layoutParams2);
            }
        }
    }

    public void ar(bg bgVar) {
        int i;
        com.baidu.tieba.homepage.topic.topicdetail.b.c cVar;
        int i2 = 0;
        Iterator<m> it = this.mTopicDetailData.mDataList.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            m next = it.next();
            if (next instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                cVar = (com.baidu.tieba.homepage.topic.topicdetail.b.c) next;
                break;
            }
            i2 = i + 1;
        }
        if (cVar != null) {
            com.baidu.tieba.homepage.topic.topicdetail.b.c cVar2 = new com.baidu.tieba.homepage.topic.topicdetail.b.c();
            cVar2.glK = cVar.glK;
            cVar2.threadData = bgVar;
            cVar2.source = 2;
            cVar2.glL = this.gmv;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.glM = this.mTopicDetailData.bxn();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.gmm.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxu() {
        if (this.mTopicDetailData != null && this.gml != null) {
            if (this.gmy > this.gmz) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bxv()));
                return;
            }
            am.l(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bxv() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.gml.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.nK();
        } else {
            drawingCache = this.gml.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
