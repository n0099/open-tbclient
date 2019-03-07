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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private g cXq;
    private com.baidu.tbadk.editortools.pb.b ckm;
    private NoNetworkView dbq;
    private PbListView dbr;
    private NoNetworkView.a emQ;
    private com.baidu.tieba.homepage.topic.topicdetail.a fOZ;
    private ImageView fPa;
    private TopicDetailHeadView fPb;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b fPc;
    private View fPd;
    private View fPe;
    private TextView fPf;
    private TextView fPg;
    private a fPh;
    private View fPi;
    private com.baidu.tieba.write.b fPj;
    private EditText fPk;
    private int fPl;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a fPm;
    a.RunnableC0251a fPn;
    private int fPo;
    private NewWriteModel.d fPp;
    private View faL;
    private BdTypeRecyclerView fxJ;
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
        this.fPe = null;
        this.fPf = null;
        this.fPg = null;
        this.mHasMore = true;
        this.fPo = 0;
        this.emQ = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.fOZ != null) {
                    TopicDetailView.this.fOZ.loadData();
                }
            }
        };
        this.ckm = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean amr() {
                if (TopicDetailView.this.fPj.cnN()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.fPj.cnP());
                    TopicDetailView.this.kt(true);
                    return true;
                }
                return false;
            }
        };
        this.fPp = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.fPh != null && TopicDetailView.this.fPh.alT() != null) {
                    TopicDetailView.this.fPh.alT().hide();
                }
                if (z) {
                    TopicDetailView.this.fPj.Ei(null);
                    TopicDetailView.this.fPj.aE(null);
                    TopicDetailView.this.fPj.qU(false);
                    if (postWriteCallBackData != null) {
                        long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                        long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                        if (d != 0 && d2 != 0) {
                            TopicDetailView.this.fPn = TopicDetailView.this.fPm.p(d, d2);
                            com.baidu.adp.lib.g.e.jH().postDelayed(TopicDetailView.this.fPn, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.fPj.aE(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.fPj.Ei(postWriteCallBackData.getErrorString());
                    if (!v.T(TopicDetailView.this.fPj.cnL())) {
                        TopicDetailView.this.kt(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.fPh != null) {
                    TopicDetailView.this.fPh.amQ();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fxJ, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.fPo += i2;
                TopicDetailView.this.bnn();
            }
        };
        this.mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.lo()) {
                        TopicDetailView.this.aCw();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).cN(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).fOx);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fOZ = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(d.h.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.activity_topic_detail_navigation);
        if (this.faL == null) {
            this.faL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.faL.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.faL.findViewById(d.g.widget_navi_back_button);
        }
        this.fPa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.topic_detail_share_layout, this);
        al.c(this.fPa, d.f.selector_topbar_share_white);
        al.j(this.mNavigationBar.mCenterText, d.C0236d.cp_btn_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(d.e.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dbq = (NoNetworkView) findViewById(d.g.activity_topic_detail_no_network_view);
        this.dbq.a(this.emQ);
        this.fPe = findViewById(d.g.pb_editor_tool_comment);
        this.fPf = (TextView) findViewById(d.g.topic_editor_tool_comment_reply_text);
        this.fPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bnm();
            }
        });
        this.fPg = (TextView) findViewById(d.g.editor_tool_opinion_text_view);
        this.fPd = findViewById(d.g.activity_topic_detail_editor);
        R(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.fPh.alT(), layoutParams);
        this.fPj = new com.baidu.tieba.write.b();
        this.fPi = findViewById(d.g.activity_topic_detail_editor_top);
        this.fxJ = (BdTypeRecyclerView) findViewById(d.g.activity_topic_detail_list);
        this.fxJ.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fxJ.setFadingEdgeLength(0);
        this.fxJ.setOverScrollMode(2);
        this.fxJ.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fxJ.addOnScrollListener(this.mScrollListener);
        al.l(this.fxJ, d.C0236d.cp_bg_line_d);
        this.fPc = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fxJ);
        this.fPb = new TopicDetailHeadView(getContext());
        this.fPb.fOX.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void sH(int i) {
                TopicDetailView.this.sG(i);
            }
        });
        if (this.cXq == null) {
            this.dbr = new PbListView(this.mPageContext.getPageActivity());
            this.dbr.getView();
        }
        this.dbr.ib(d.C0236d.cp_bg_line_e);
        this.dbr.setHeight(l.h(this.mPageContext.getPageActivity(), d.e.tbds182));
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.ia(d.C0236d.cp_cont_e);
        this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_e));
        this.dbr.ib(al.getColor(d.C0236d.cp_bg_line_d));
        this.dbr.hX(al.getColor(d.C0236d.cp_bg_line_c));
        this.dbr.setText(getResources().getString(d.j.list_has_no_more));
        this.dbr.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.fPm == null) {
            this.fPm = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.fPm.i(this.mPageContext.getUniqueId());
        }
    }

    private void R(Bundle bundle) {
        this.fPh = (a) new b().dd(getContext());
        if (this.fPh != null) {
            this.fPh.a(this.mPageContext);
            this.fPh.b(this.fPp);
            this.fPh.a(this.ckm);
            this.fPh.alT().eH(true);
            this.fPh.a((BaseActivity) getContext(), bundle);
            this.fPh.amQ();
            this.fPh.alT().setId(d.g.topic_editor);
            this.fPk = this.fPh.bnl().getInputView();
            this.fPk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.fPj != null) {
                        if (!TopicDetailView.this.fPj.cnO()) {
                            TopicDetailView.this.kt(false);
                        }
                        TopicDetailView.this.fPj.qV(false);
                    }
                }
            });
        }
    }

    public void kt(boolean z) {
        if (this.fPk != null && this.fPk.getText() != null) {
            int selectionEnd = this.fPk.getSelectionEnd();
            SpannableStringBuilder b = this.fPj.b(this.fPk.getText());
            if (b != null) {
                this.fPj.qV(true);
                this.fPk.setText(b);
                if (z && this.fPj.cnM() >= 0) {
                    this.fPk.requestFocus();
                    this.fPk.setSelection(this.fPj.cnM());
                } else {
                    this.fPk.setSelection(selectionEnd);
                }
                this.fPj.qU(this.fPj.cnM() >= 0);
            }
        }
    }

    public void bnm() {
        if (bc.cZ(getContext())) {
            this.fPh.amT();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new am("c13359").bJ("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(int i) {
        this.fPl = i;
        this.fPg.setVisibility(0);
        if (i == 1) {
            this.fPg.setText(d.j.topic_detail_pk_support);
            al.k(this.fPg, d.f.topic_discuss_support_bg);
        } else if (i == 2) {
            this.fPg.setText(d.j.topic_detail_pk_oppose);
            al.k(this.fPg, d.f.topic_discuss_oppose_bg);
        } else {
            this.fPg.setText(d.j.topic_detail_pk_chigua);
            al.k(this.fPg, d.f.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1) {
            this.fPg.setTextColor(-2130706433);
        } else {
            al.j(this.fPg, d.C0236d.cp_btn_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int h;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aCv();
            } else if (!this.mHasMore) {
                aCv();
            } else {
                aCu();
            }
            if (!StringUtils.isNull(aVar.bAk)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(d.j.daily_topic_name), ap.g(aVar.bAk, 14, "...")));
            }
            this.fPb.setData(aVar.fOp);
            this.fxJ.addHeaderView(this.fPb);
            this.fPc.setData(aVar.mDataList);
            if (this.mTopicDetailData.fOp.fOu != null) {
                if (this.mTopicDetailData.fOp.fOu.fPR.fPX) {
                    sG(1);
                } else if (this.mTopicDetailData.fOp.fOu.fPS.fPX) {
                    sG(2);
                } else {
                    sG(0);
                }
                h = l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds130);
            } else {
                h = l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds50);
                this.fPg.setVisibility(8);
            }
            this.fPf.setPadding(h, 0, 0, 0);
            bnn();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aCv();
        } else {
            aCu();
        }
        if (i == 0 && list != null && !v.T(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).fOA = this.mTopicDetailData.bng();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fxJ.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCw() {
        this.fxJ.setNextPage(null);
    }

    public void aCu() {
        this.mHasMore = true;
        this.fxJ.setNextPage(this.dbr);
        this.dbr.aeC();
    }

    public void aCv() {
        this.fxJ.setNextPage(this.dbr);
        this.dbr.aeD();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.faL) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.fPa && this.mTopicDetailData.topicId > 0 && com.baidu.tbadk.plugins.c.b(this.mPageContext, "com.baidu.tieba.pluginCore")) {
            aeX();
            TiebaStatic.log(new am("c13364").bJ("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aeX() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.bAk;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(d.j.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.fOo) ? null : Uri.parse(this.mTopicDetailData.fOo);
            final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = str2;
            dVar.linkUrl = str3;
            dVar.cbp = true;
            dVar.extData = valueOf;
            dVar.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.bh(dVar.linkUrl);
                    l.showToast(TopicDetailView.this.getContext(), view.getResources().getString(d.j.copy_pb_url_success));
                }
            });
            this.mPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            bnn();
            al.j(this.mNavigationBar.mCenterText, d.C0236d.cp_btn_a);
            al.k(this.fPe, d.C0236d.cp_cont_g);
            al.j(this.fPf, d.C0236d.cp_cont_d);
            al.k(this.fPf, d.f.topic_discuss_input_bg);
            sG(this.fPl);
            al.c(this.mBackImageView, d.f.icon_topbar_return_white_n, d.f.icon_topbar_return_white_s);
            if (this.fPa != null) {
                al.c(this.fPa, d.f.selector_topbar_share_white);
            }
            if (this.mPageContext != null && this.dbq != null) {
                this.dbq.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.cXq != null) {
                this.cXq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fPh != null && this.fPh.alT() != null) {
                this.fPh.alT().onChangeSkinType(this.mSkinType);
            }
            if (this.dbr != null) {
                this.dbr.ia(d.C0236d.cp_cont_e);
                this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_e));
                this.dbr.ib(al.getColor(d.C0236d.cp_bg_line_d));
                this.dbr.hX(al.getColor(d.C0236d.cp_bg_line_c));
            }
            if (this.fPb != null) {
                this.fPb.onChangeSkinType();
            }
            if (this.fPc != null) {
                this.fPc.notifyDataSetChanged();
            }
            al.l(this.fxJ, d.C0236d.cp_bg_line_d);
        }
    }

    public void cE(boolean z) {
        if (!aXq()) {
            if (this.cXq == null) {
                this.cXq = new g(getContext());
                this.cXq.onChangeSkinType();
            }
            this.cXq.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.cXq != null) {
            this.cXq.dettachView(this);
            this.cXq = null;
        }
    }

    public boolean aXq() {
        if (this.cXq != null) {
            return this.cXq.isViewAttached();
        }
        return false;
    }

    public void iD(boolean z) {
        if (!aXr()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && TopicDetailView.this.fOZ != null) {
                            TopicDetailView.this.fOZ.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.jR(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.anC();
            this.fxJ.setVisibility(8);
        }
    }

    public void aBt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fxJ.setVisibility(0);
    }

    public boolean aXr() {
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
        this.fxJ.setOnSrollToBottomListener(null);
        if (this.dbq != null) {
            this.dbq.b(this.emQ);
        }
        if (this.fPh != null) {
            this.fPh.onDestory();
        }
        if (this.fPn != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fPn);
        }
        hideLoadingView();
        aBt();
    }

    public a getEditor() {
        return this.fPh;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.fPi != null) {
            ViewGroup.LayoutParams layoutParams = this.fPi.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.fPh.alT().isVisible()) {
                    layoutParams2.addRule(2, this.fPh.alT().getId());
                } else {
                    layoutParams2.addRule(2, this.fPd.getId());
                }
                this.fPi.setLayoutParams(layoutParams2);
            }
        }
    }

    public void au(bg bgVar) {
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
            cVar2.fOx = cVar.fOx;
            cVar2.threadData = bgVar;
            cVar2.fOz = 2;
            cVar2.fOy = this.fPl;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.fOA = this.mTopicDetailData.bng();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.fPc.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnn() {
        if (this.mTopicDetailData != null && this.fPb != null) {
            if (StringUtils.isNull(this.mTopicDetailData.fOp.fOt)) {
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bno()));
            } else if (!StringUtils.isNull(this.mTopicDetailData.fOp.fOt)) {
                if (this.fPo > 44) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bno()));
                    return;
                }
                al.l(this.mNavigationBar.getBarBgView(), d.C0236d.transparent);
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
            }
        }
    }

    public Bitmap bno() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.fPb.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.oy();
        } else {
            drawingCache = this.fPb.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
