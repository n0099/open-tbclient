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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
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
    private com.baidu.tbadk.editortools.pb.b cuP;
    private g dly;
    private NoNetworkView dpy;
    private PbListView dpz;
    private NoNetworkView.a eIX;
    private BdTypeRecyclerView fVX;
    private View fxX;
    private com.baidu.tieba.homepage.topic.topicdetail.a goS;
    private ImageView goT;
    private TopicDetailHeadView goU;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b goV;
    private View goW;
    private View goX;
    private TextView goY;
    private TextView goZ;
    private a gpa;
    private View gpb;
    private com.baidu.tieba.write.b gpc;
    private EditText gpd;
    private int gpe;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a gpf;
    a.RunnableC0338a gpg;
    private int gph;
    private int gpi;
    private NewWriteModel.d gpj;
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
        this.goX = null;
        this.goY = null;
        this.goZ = null;
        this.mHasMore = true;
        this.gph = 0;
        this.gpi = 44;
        this.eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void es(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.goS != null) {
                    TopicDetailView.this.goS.loadData();
                }
            }
        };
        this.cuP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean asK() {
                if (TopicDetailView.this.gpc.cAp()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.gpc.cAr());
                    TopicDetailView.this.lB(true);
                    return true;
                }
                return false;
            }
        };
        this.gpj = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.gpa != null && TopicDetailView.this.gpa.asm() != null) {
                    TopicDetailView.this.gpa.asm().hide();
                }
                if (z) {
                    TopicDetailView.this.gpc.Hb(null);
                    TopicDetailView.this.gpc.aI(null);
                    TopicDetailView.this.gpc.sd(false);
                    if (postWriteCallBackData != null) {
                        long e = com.baidu.adp.lib.g.b.e(postWriteCallBackData.getPostId(), 0L);
                        long e2 = com.baidu.adp.lib.g.b.e(postWriteCallBackData.getThreadId(), 0L);
                        if (e != 0 && e2 != 0) {
                            TopicDetailView.this.gpg = TopicDetailView.this.gpf.p(e, e2);
                            com.baidu.adp.lib.g.e.iK().postDelayed(TopicDetailView.this.gpg, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.gpc.aI(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.gpc.Hb(postWriteCallBackData.getErrorString());
                    if (!v.aa(TopicDetailView.this.gpc.cAn())) {
                        TopicDetailView.this.lB(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.gpa != null) {
                    TopicDetailView.this.gpa.atj();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fVX, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.gph += i2;
                TopicDetailView.this.byw();
            }
        };
        this.mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.kt()) {
                        TopicDetailView.this.aKQ();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).du(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).got);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.goS = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.fxX == null) {
            this.fxX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fxX.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.fxX.findViewById(R.id.widget_navi_back_button);
        }
        this.goT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.ajv().a(this.goT, R.drawable.icon_pure_topbar_share_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.j(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dpy = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.dpy.a(this.eIX);
        this.goX = findViewById(R.id.pb_editor_tool_comment);
        this.goY = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.goY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.byv();
            }
        });
        this.goZ = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.goW = findViewById(R.id.activity_topic_detail_editor);
        S(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.gpa.asm(), layoutParams);
        this.gpc = new com.baidu.tieba.write.b();
        this.gpb = findViewById(R.id.activity_topic_detail_editor_top);
        this.fVX = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.fVX.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fVX.setFadingEdgeLength(0);
        this.fVX.setOverScrollMode(2);
        this.fVX.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fVX.addOnScrollListener(this.mScrollListener);
        am.l(this.fVX, R.color.cp_bg_line_d);
        this.goV = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fVX);
        this.goU = new TopicDetailHeadView(getContext());
        this.goU.goQ.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void uo(int i) {
                TopicDetailView.this.un(i);
            }
        });
        if (this.dly == null) {
            this.dpz = new PbListView(this.mPageContext.getPageActivity());
            this.dpz.getView();
        }
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.iW(R.color.cp_cont_e);
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_e));
        this.dpz.iX(am.getColor(R.color.cp_bg_line_d));
        this.dpz.iT(am.getColor(R.color.cp_bg_line_c));
        this.dpz.setText(getResources().getString(R.string.list_has_no_more));
        this.dpz.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.gpf == null) {
            this.gpf = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.gpf.j(this.mPageContext.getUniqueId());
        }
    }

    private void S(Bundle bundle) {
        this.gpa = (a) new b().cK(getContext());
        if (this.gpa != null) {
            this.gpa.a(this.mPageContext);
            this.gpa.b(this.gpj);
            this.gpa.a(this.cuP);
            this.gpa.asm().fk(true);
            this.gpa.asm().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.gpa.a((BaseActivity) getContext(), bundle);
            this.gpa.atj();
            this.gpa.asm().setId(R.id.topic_editor);
            this.gpd = this.gpa.byu().getInputView();
            this.gpd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.gpc != null) {
                        if (!TopicDetailView.this.gpc.cAq()) {
                            TopicDetailView.this.lB(false);
                        }
                        TopicDetailView.this.gpc.se(false);
                    }
                }
            });
        }
    }

    public void lB(boolean z) {
        if (this.gpd != null && this.gpd.getText() != null) {
            int selectionEnd = this.gpd.getSelectionEnd();
            SpannableStringBuilder b = this.gpc.b(this.gpd.getText());
            if (b != null) {
                this.gpc.se(true);
                this.gpd.setText(b);
                if (z && this.gpc.cAo() >= 0) {
                    this.gpd.requestFocus();
                    this.gpd.setSelection(this.gpc.cAo());
                } else {
                    this.gpd.setSelection(selectionEnd);
                }
                this.gpc.sd(this.gpc.cAo() >= 0);
            }
        }
    }

    public void byv() {
        if (bc.cF(getContext())) {
            this.gpa.atm();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void un(int i) {
        this.gpe = i;
        this.goZ.setVisibility(0);
        if (i == 1) {
            this.goZ.setText(R.string.topic_detail_pk_support);
            am.k(this.goZ, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.goZ.setText(R.string.topic_detail_pk_oppose);
            am.k(this.goZ, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.goZ.setText(R.string.topic_detail_pk_chigua);
            am.k(this.goZ, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.goZ.setTextColor(-2130706433);
        } else {
            am.j(this.goZ, R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int g;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aKP();
            } else if (!this.mHasMore) {
                aKP();
            } else {
                aKO();
            }
            if (!StringUtils.isNull(aVar.bJg)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.j(aVar.bJg, 14, "...")));
            }
            this.goU.setData(aVar.gol);
            this.fVX.addHeaderView(this.goU);
            this.goV.setData(aVar.mDataList);
            if (this.mTopicDetailData.gol.goq != null) {
                if (this.mTopicDetailData.gol.goq.gpM.gpS) {
                    un(1);
                } else if (this.mTopicDetailData.gol.goq.gpN.gpS) {
                    un(2);
                } else {
                    un(0);
                }
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.goZ.setVisibility(8);
            }
            this.goY.setPadding(g, 0, 0, 0);
            byw();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aKP();
        } else {
            aKO();
        }
        if (i == 0 && list != null && !v.aa(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).gov = this.mTopicDetailData.byp();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fVX.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKQ() {
        this.fVX.setNextPage(null);
    }

    public void aKO() {
        this.mHasMore = true;
        this.fVX.setNextPage(this.dpz);
        this.dpz.akR();
    }

    public void aKP() {
        this.fVX.setNextPage(this.dpz);
        this.dpz.akS();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fxX) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.goT && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            alm();
            TiebaStatic.log(new an("c13364").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void alm() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.bJg;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.gok) ? null : Uri.parse(this.mTopicDetailData.gok);
            final com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = str2;
            eVar.linkUrl = str3;
            eVar.clA = true;
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
            byw();
            am.j(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
            am.k(this.goX, R.color.cp_bg_line_h);
            am.j(this.goY, R.color.cp_cont_d);
            this.goY.setBackgroundDrawable(am.X(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            un(this.gpe);
            SvgManager.ajv().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.goT != null) {
                SvgManager.ajv().a(this.goT, R.drawable.icon_pure_topbar_share_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.dpy != null) {
                this.dpy.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.dly != null) {
                this.dly.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gpa != null && this.gpa.asm() != null) {
                this.gpa.asm().onChangeSkinType(this.mSkinType);
            }
            if (this.dpz != null) {
                this.dpz.iW(R.color.cp_cont_e);
                this.dpz.setTextColor(am.getColor(R.color.cp_cont_e));
                this.dpz.iX(am.getColor(R.color.cp_bg_line_d));
                this.dpz.iT(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.goU != null) {
                this.goU.onChangeSkinType();
            }
            if (this.goV != null) {
                this.goV.notifyDataSetChanged();
            }
            am.l(this.fVX, R.color.cp_bg_line_e);
        }
    }

    public void cY(boolean z) {
        if (!bhr()) {
            if (this.dly == null) {
                this.dly = new g(getContext());
                this.dly.onChangeSkinType();
            }
            this.dly.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dly != null) {
            this.dly.dettachView(this);
            this.dly = null;
        }
    }

    public boolean bhr() {
        if (this.dly != null) {
            return this.dly.isViewAttached();
        }
        return false;
    }

    public void jx(boolean z) {
        if (!bhs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && TopicDetailView.this.goS != null) {
                            TopicDetailView.this.goS.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.kO(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atW();
            this.fVX.setVisibility(8);
            SvgManager.ajv().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void aJN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fVX.setVisibility(0);
        SvgManager.ajv().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bhs() {
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
        this.fVX.setOnSrollToBottomListener(null);
        if (this.dpy != null) {
            this.dpy.b(this.eIX);
        }
        if (this.gpa != null) {
            this.gpa.onDestory();
        }
        if (this.gpg != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gpg);
        }
        hideLoadingView();
        aJN();
    }

    public a getEditor() {
        return this.gpa;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.gpb != null) {
            ViewGroup.LayoutParams layoutParams = this.gpb.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.gpa.asm().isVisible()) {
                    layoutParams2.addRule(2, this.gpa.asm().getId());
                } else {
                    layoutParams2.addRule(2, this.goW.getId());
                }
                this.gpb.setLayoutParams(layoutParams2);
            }
        }
    }

    public void at(bh bhVar) {
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
            cVar2.got = cVar.got;
            cVar2.threadData = bhVar;
            cVar2.source = 2;
            cVar2.gou = this.gpe;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.gov = this.mTopicDetailData.byp();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.goV.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byw() {
        if (this.mTopicDetailData != null && this.goU != null) {
            if (this.gph > this.gpi) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(byx()));
                return;
            }
            am.l(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap byx() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.goU.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.nK();
        } else {
            drawingCache = this.goU.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
