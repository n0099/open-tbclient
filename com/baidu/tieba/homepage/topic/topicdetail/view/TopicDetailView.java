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
import com.baidu.tbadk.core.data.bh;
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
    private com.baidu.tbadk.editortools.pb.b ctS;
    private g djN;
    private NoNetworkView dnM;
    private PbListView dnN;
    private NoNetworkView.a eHo;
    private BdTypeRecyclerView fUg;
    private View fwk;
    private com.baidu.tieba.homepage.topic.topicdetail.a gnb;
    private ImageView gnc;
    private TopicDetailHeadView gnd;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b gne;
    private View gnf;
    private View gng;
    private TextView gnh;
    private TextView gni;
    private a gnj;
    private View gnk;
    private com.baidu.tieba.write.b gnl;
    private EditText gnm;
    private int gnn;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a gno;
    a.RunnableC0327a gnp;
    private int gnq;
    private int gnr;
    private NewWriteModel.d gns;
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
        this.gng = null;
        this.gnh = null;
        this.gni = null;
        this.mHasMore = true;
        this.gnq = 0;
        this.gnr = 44;
        this.eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.gnb != null) {
                    TopicDetailView.this.gnb.loadData();
                }
            }
        };
        this.ctS = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean asy() {
                if (TopicDetailView.this.gnl.czB()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.gnl.czD());
                    TopicDetailView.this.ly(true);
                    return true;
                }
                return false;
            }
        };
        this.gns = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.gnj != null && TopicDetailView.this.gnj.asa() != null) {
                    TopicDetailView.this.gnj.asa().hide();
                }
                if (z) {
                    TopicDetailView.this.gnl.GB(null);
                    TopicDetailView.this.gnl.aI(null);
                    TopicDetailView.this.gnl.sa(false);
                    if (postWriteCallBackData != null) {
                        long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                        long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                        if (c != 0 && c2 != 0) {
                            TopicDetailView.this.gnp = TopicDetailView.this.gno.p(c, c2);
                            com.baidu.adp.lib.g.e.iK().postDelayed(TopicDetailView.this.gnp, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.gnl.aI(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.gnl.GB(postWriteCallBackData.getErrorString());
                    if (!v.aa(TopicDetailView.this.gnl.czz())) {
                        TopicDetailView.this.ly(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.gnj != null) {
                    TopicDetailView.this.gnj.asX();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fUg, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.gnq += i2;
                TopicDetailView.this.bxI();
            }
        };
        this.mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.kt()) {
                        TopicDetailView.this.aKm();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dr(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).gmC);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gnb = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.fwk == null) {
            this.fwk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fwk.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.fwk.findViewById(R.id.widget_navi_back_button);
        }
        this.gnc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        am.c(this.gnc, (int) R.drawable.selector_topbar_share_white);
        am.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dnM = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.dnM.a(this.eHo);
        this.gng = findViewById(R.id.pb_editor_tool_comment);
        this.gnh = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.gnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bxH();
            }
        });
        this.gni = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.gnf = findViewById(R.id.activity_topic_detail_editor);
        S(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.gnj.asa(), layoutParams);
        this.gnl = new com.baidu.tieba.write.b();
        this.gnk = findViewById(R.id.activity_topic_detail_editor_top);
        this.fUg = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.fUg.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fUg.setFadingEdgeLength(0);
        this.fUg.setOverScrollMode(2);
        this.fUg.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fUg.addOnScrollListener(this.mScrollListener);
        am.l(this.fUg, R.color.cp_bg_line_d);
        this.gne = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fUg);
        this.gnd = new TopicDetailHeadView(getContext());
        this.gnd.gmZ.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void uk(int i) {
                TopicDetailView.this.uj(i);
            }
        });
        if (this.djN == null) {
            this.dnN = new PbListView(this.mPageContext.getPageActivity());
            this.dnN.getView();
        }
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.iT(R.color.cp_cont_e);
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_e));
        this.dnN.iU(am.getColor(R.color.cp_bg_line_d));
        this.dnN.iQ(am.getColor(R.color.cp_bg_line_c));
        this.dnN.setText(getResources().getString(R.string.list_has_no_more));
        this.dnN.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.gno == null) {
            this.gno = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.gno.j(this.mPageContext.getUniqueId());
        }
    }

    private void S(Bundle bundle) {
        this.gnj = (a) new b().cK(getContext());
        if (this.gnj != null) {
            this.gnj.a(this.mPageContext);
            this.gnj.b(this.gns);
            this.gnj.a(this.ctS);
            this.gnj.asa().fh(true);
            this.gnj.a((BaseActivity) getContext(), bundle);
            this.gnj.asX();
            this.gnj.asa().setId(R.id.topic_editor);
            this.gnm = this.gnj.bxG().getInputView();
            this.gnm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.gnl != null) {
                        if (!TopicDetailView.this.gnl.czC()) {
                            TopicDetailView.this.ly(false);
                        }
                        TopicDetailView.this.gnl.sb(false);
                    }
                }
            });
        }
    }

    public void ly(boolean z) {
        if (this.gnm != null && this.gnm.getText() != null) {
            int selectionEnd = this.gnm.getSelectionEnd();
            SpannableStringBuilder b = this.gnl.b(this.gnm.getText());
            if (b != null) {
                this.gnl.sb(true);
                this.gnm.setText(b);
                if (z && this.gnl.czA() >= 0) {
                    this.gnm.requestFocus();
                    this.gnm.setSelection(this.gnl.czA());
                } else {
                    this.gnm.setSelection(selectionEnd);
                }
                this.gnl.sa(this.gnl.czA() >= 0);
            }
        }
    }

    public void bxH() {
        if (bd.cF(getContext())) {
            this.gnj.ata();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(int i) {
        this.gnn = i;
        this.gni.setVisibility(0);
        if (i == 1) {
            this.gni.setText(R.string.topic_detail_pk_support);
            am.k(this.gni, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.gni.setText(R.string.topic_detail_pk_oppose);
            am.k(this.gni, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.gni.setText(R.string.topic_detail_pk_chigua);
            am.k(this.gni, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1) {
            this.gni.setTextColor(-2130706433);
        } else {
            am.j(this.gni, R.color.cp_btn_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int g;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aKl();
            } else if (!this.mHasMore) {
                aKl();
            } else {
                aKk();
            }
            if (!StringUtils.isNull(aVar.bII)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.j(aVar.bII, 14, "...")));
            }
            this.gnd.setData(aVar.gmu);
            this.fUg.addHeaderView(this.gnd);
            this.gne.setData(aVar.mDataList);
            if (this.mTopicDetailData.gmu.gmz != null) {
                if (this.mTopicDetailData.gmu.gmz.gnV.gob) {
                    uj(1);
                } else if (this.mTopicDetailData.gmu.gmz.gnW.gob) {
                    uj(2);
                } else {
                    uj(0);
                }
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            } else {
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.gni.setVisibility(8);
            }
            this.gnh.setPadding(g, 0, 0, 0);
            bxI();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aKl();
        } else {
            aKk();
        }
        if (i == 0 && list != null && !v.aa(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).gmE = this.mTopicDetailData.bxB();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fUg.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKm() {
        this.fUg.setNextPage(null);
    }

    public void aKk() {
        this.mHasMore = true;
        this.fUg.setNextPage(this.dnN);
        this.dnN.akF();
    }

    public void aKl() {
        this.fUg.setNextPage(this.dnN);
        this.dnN.akG();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fwk) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gnc && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            ala();
            TiebaStatic.log(new an("c13364").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void ala() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.bII;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.gmt) ? null : Uri.parse(this.mTopicDetailData.gmt);
            final com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = str2;
            eVar.linkUrl = str3;
            eVar.ckF = true;
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
            bxI();
            am.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
            am.k(this.gng, R.color.cp_cont_g);
            am.j(this.gnh, R.color.cp_cont_d);
            am.k(this.gnh, R.drawable.topic_discuss_input_bg);
            uj(this.gnn);
            am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
            if (this.gnc != null) {
                am.c(this.gnc, (int) R.drawable.selector_topbar_share_white);
            }
            if (this.mPageContext != null && this.dnM != null) {
                this.dnM.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.djN != null) {
                this.djN.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gnj != null && this.gnj.asa() != null) {
                this.gnj.asa().onChangeSkinType(this.mSkinType);
            }
            if (this.dnN != null) {
                this.dnN.iT(R.color.cp_cont_e);
                this.dnN.setTextColor(am.getColor(R.color.cp_cont_e));
                this.dnN.iU(am.getColor(R.color.cp_bg_line_d));
                this.dnN.iQ(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.gnd != null) {
                this.gnd.onChangeSkinType();
            }
            if (this.gne != null) {
                this.gne.notifyDataSetChanged();
            }
            am.l(this.fUg, R.color.cp_bg_line_d);
        }
    }

    public void cY(boolean z) {
        if (!bgL()) {
            if (this.djN == null) {
                this.djN = new g(getContext());
                this.djN.onChangeSkinType();
            }
            this.djN.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.djN != null) {
            this.djN.dettachView(this);
            this.djN = null;
        }
    }

    public boolean bgL() {
        if (this.djN != null) {
            return this.djN.isViewAttached();
        }
        return false;
    }

    public void ju(boolean z) {
        if (!bgM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && TopicDetailView.this.gnb != null) {
                            TopicDetailView.this.gnb.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.kL(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atK();
            this.fUg.setVisibility(8);
            am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
        }
    }

    public void aJj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fUg.setVisibility(0);
        am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
    }

    public boolean bgM() {
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
        this.fUg.setOnSrollToBottomListener(null);
        if (this.dnM != null) {
            this.dnM.b(this.eHo);
        }
        if (this.gnj != null) {
            this.gnj.onDestory();
        }
        if (this.gnp != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gnp);
        }
        hideLoadingView();
        aJj();
    }

    public a getEditor() {
        return this.gnj;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.gnk != null) {
            ViewGroup.LayoutParams layoutParams = this.gnk.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.gnj.asa().isVisible()) {
                    layoutParams2.addRule(2, this.gnj.asa().getId());
                } else {
                    layoutParams2.addRule(2, this.gnf.getId());
                }
                this.gnk.setLayoutParams(layoutParams2);
            }
        }
    }

    public void as(bh bhVar) {
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
            cVar2.gmC = cVar.gmC;
            cVar2.threadData = bhVar;
            cVar2.source = 2;
            cVar2.gmD = this.gnn;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.gmE = this.mTopicDetailData.bxB();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.gne.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxI() {
        if (this.mTopicDetailData != null && this.gnd != null) {
            if (this.gnq > this.gnr) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bxJ()));
                return;
            }
            am.l(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bxJ() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.gnd.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.nK();
        } else {
            drawingCache = this.gnd.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
