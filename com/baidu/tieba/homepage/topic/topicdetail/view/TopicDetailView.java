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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
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
    private com.baidu.tbadk.editortools.pb.b cGi;
    private g dDz;
    private NoNetworkView dvR;
    private PbListView dvS;
    private NoNetworkView.a eQL;
    private BdTypeRecyclerView fUA;
    private View fwu;
    private com.baidu.tieba.homepage.topic.topicdetail.a gnA;
    private ImageView gnB;
    private TopicDetailHeadView gnC;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b gnD;
    private View gnE;
    private View gnF;
    private TextView gnG;
    private TextView gnH;
    private a gnI;
    private View gnJ;
    private com.baidu.tieba.write.b gnK;
    private EditText gnL;
    private int gnM;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a gnN;
    a.RunnableC0427a gnO;
    private int gnP;
    private int gnQ;
    private NewWriteModel.d gnR;
    private ImageView mBackImageView;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private int mSkinType;
    private com.baidu.tieba.homepage.topic.topicdetail.b.a mTopicDetailData;
    private BdListView.e xE;

    public TopicDetailView(TbPageContext<?> tbPageContext, com.baidu.tieba.homepage.topic.topicdetail.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gnF = null;
        this.gnG = null;
        this.gnH = null;
        this.mHasMore = true;
        this.gnP = 0;
        this.gnQ = 44;
        this.eQL = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.gnA != null) {
                    TopicDetailView.this.gnA.loadData();
                }
            }
        };
        this.cGi = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean auu() {
                if (TopicDetailView.this.gnK.cxy()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.gnK.cxA());
                    TopicDetailView.this.lp(true);
                    return true;
                }
                return false;
            }
        };
        this.gnR = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.gnI != null && TopicDetailView.this.gnI.atX() != null) {
                    TopicDetailView.this.gnI.atX().hide();
                }
                if (z) {
                    TopicDetailView.this.gnK.Fv(null);
                    TopicDetailView.this.gnK.aM(null);
                    TopicDetailView.this.gnK.rK(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.g.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.g.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.gnO = TopicDetailView.this.gnN.v(j, j2);
                            com.baidu.adp.lib.g.e.fZ().postDelayed(TopicDetailView.this.gnO, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.gnK.aM(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.gnK.Fv(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.gnK.cxw())) {
                        TopicDetailView.this.lp(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.gnI != null) {
                    TopicDetailView.this.gnI.auT();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fUA, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.gnP += i2;
                TopicDetailView.this.bvy();
            }
        };
        this.xE = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.aKi();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).cT(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).gnb);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gnA = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.fwu == null) {
            this.fwu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fwu.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.fwu.findViewById(R.id.widget_navi_back_button);
        }
        this.gnB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.amL().a(this.gnB, R.drawable.icon_pure_topbar_share_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dvR = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.dvR.a(this.eQL);
        this.gnF = findViewById(R.id.pb_editor_tool_comment);
        this.gnG = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.gnG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bvx();
            }
        });
        this.gnH = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.gnE = findViewById(R.id.activity_topic_detail_editor);
        R(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.gnI.atX(), layoutParams);
        this.gnK = new com.baidu.tieba.write.b();
        this.gnJ = findViewById(R.id.activity_topic_detail_editor_top);
        this.fUA = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.fUA.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fUA.setFadingEdgeLength(0);
        this.fUA.setOverScrollMode(2);
        this.fUA.setOnSrollToBottomListener(this.xE);
        this.fUA.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.fUA, R.color.cp_bg_line_d);
        this.gnD = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fUA);
        this.gnC = new TopicDetailHeadView(getContext());
        this.gnC.gny.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void ti(int i) {
                TopicDetailView.this.th(i);
            }
        });
        if (this.dDz == null) {
            this.dvS = new PbListView(this.mPageContext.getPageActivity());
            this.dvS.getView();
        }
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_e));
        this.dvS.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.dvS.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.dvS.setText(getResources().getString(R.string.list_has_no_more));
        this.dvS.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.gnN == null) {
            this.gnN = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.gnN.j(this.mPageContext.getUniqueId());
        }
    }

    private void R(Bundle bundle) {
        this.gnI = (a) new b().cw(getContext());
        if (this.gnI != null) {
            this.gnI.a(this.mPageContext);
            this.gnI.b(this.gnR);
            this.gnI.a(this.cGi);
            this.gnI.atX().fe(true);
            this.gnI.atX().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.gnI.a((BaseActivity) getContext(), bundle);
            this.gnI.auT();
            this.gnI.atX().setId(R.id.topic_editor);
            this.gnL = this.gnI.bvw().getInputView();
            this.gnL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.gnK != null) {
                        if (!TopicDetailView.this.gnK.cxz()) {
                            TopicDetailView.this.lp(false);
                        }
                        TopicDetailView.this.gnK.rL(false);
                    }
                }
            });
        }
    }

    public void lp(boolean z) {
        if (this.gnL != null && this.gnL.getText() != null) {
            int selectionEnd = this.gnL.getSelectionEnd();
            SpannableStringBuilder a = this.gnK.a(this.gnL.getText());
            if (a != null) {
                this.gnK.rL(true);
                this.gnL.setText(a);
                if (z && this.gnK.cxx() >= 0) {
                    this.gnL.requestFocus();
                    this.gnL.setSelection(this.gnK.cxx());
                } else {
                    this.gnL.setSelection(selectionEnd);
                }
                this.gnK.rK(this.gnK.cxx() >= 0);
            }
        }
    }

    public void bvx() {
        if (bc.checkUpIsLogin(getContext())) {
            this.gnI.auW();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").bS("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        this.gnM = i;
        this.gnH.setVisibility(0);
        if (i == 1) {
            this.gnH.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.gnH, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.gnH.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.gnH, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.gnH.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.gnH, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.gnH.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.gnH, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aKh();
            } else if (!this.mHasMore) {
                aKh();
            } else {
                aKg();
            }
            if (!StringUtils.isNull(aVar.bZW)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.bZW, 14, StringHelper.STRING_MORE)));
            }
            this.gnC.setData(aVar.gmT);
            this.fUA.addHeaderView(this.gnC);
            this.gnD.setData(aVar.mDataList);
            if (this.mTopicDetailData.gmT.gmY != null) {
                if (this.mTopicDetailData.gmT.gmY.gou.goA) {
                    th(1);
                } else if (this.mTopicDetailData.gmT.gmY.gov.goA) {
                    th(2);
                } else {
                    th(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.gnH.setVisibility(8);
            }
            this.gnG.setPadding(dimens, 0, 0, 0);
            bvy();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aKh();
        } else {
            aKg();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).gnd = this.mTopicDetailData.bvr();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fUA.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKi() {
        this.fUA.setNextPage(null);
    }

    public void aKg() {
        this.mHasMore = true;
        this.fUA.setNextPage(this.dvS);
        this.dvS.startLoadData();
    }

    public void aKh() {
        this.fUA.setNextPage(this.dvS);
        this.dvS.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fwu) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gnB && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            anY();
            TiebaStatic.log(new an("c13364").bS("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void anY() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.bZW;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.gmS) ? null : Uri.parse(this.mTopicDetailData.gmS);
            final com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = str2;
            eVar.linkUrl = str3;
            eVar.cxJ = true;
            eVar.extData = valueOf;
            eVar.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), eVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(eVar.linkUrl);
                    l.showToast(TopicDetailView.this.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            bvy();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.gnF, R.color.cp_bg_line_h);
            am.setViewTextColor(this.gnG, (int) R.color.cp_cont_d);
            this.gnG.setBackgroundDrawable(am.Z(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            th(this.gnM);
            SvgManager.amL().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.gnB != null) {
                SvgManager.amL().a(this.gnB, R.drawable.icon_pure_topbar_share_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.dvR != null) {
                this.dvR.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.dDz != null) {
                this.dDz.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gnI != null && this.gnI.atX() != null) {
                this.gnI.atX().onChangeSkinType(this.mSkinType);
            }
            if (this.dvS != null) {
                this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
                this.dvS.setTextColor(am.getColor(R.color.cp_cont_e));
                this.dvS.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.dvS.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.gnC != null) {
                this.gnC.onChangeSkinType();
            }
            if (this.gnD != null) {
                this.gnD.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.fUA, R.color.cp_bg_line_e);
        }
    }

    public void dp(boolean z) {
        if (!bfj()) {
            if (this.dDz == null) {
                this.dDz = new g(getContext());
                this.dDz.onChangeSkinType();
            }
            this.dDz.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this);
            this.dDz = null;
        }
    }

    public boolean bfj() {
        if (this.dDz != null) {
            return this.dDz.isViewAttached();
        }
        return false;
    }

    public void jm(boolean z) {
        if (!bfk()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.gnA != null) {
                            TopicDetailView.this.gnA.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.fUA.setVisibility(8);
            SvgManager.amL().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void aJm() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fUA.setVisibility(0);
        SvgManager.amL().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bfk() {
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
        this.fUA.setOnSrollToBottomListener(null);
        if (this.dvR != null) {
            this.dvR.b(this.eQL);
        }
        if (this.gnI != null) {
            this.gnI.onDestory();
        }
        if (this.gnO != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.gnO);
        }
        hideLoadingView();
        aJm();
    }

    public a getEditor() {
        return this.gnI;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.gnJ != null) {
            ViewGroup.LayoutParams layoutParams = this.gnJ.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.gnI.atX().isVisible()) {
                    layoutParams2.addRule(2, this.gnI.atX().getId());
                } else {
                    layoutParams2.addRule(2, this.gnE.getId());
                }
                this.gnJ.setLayoutParams(layoutParams2);
            }
        }
    }

    public void ar(bh bhVar) {
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
            cVar2.gnb = cVar.gnb;
            cVar2.caz = bhVar;
            cVar2.source = 2;
            cVar2.gnc = this.gnM;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.gnd = this.mTopicDetailData.bvr();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.gnD.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvy() {
        if (this.mTopicDetailData != null && this.gnC != null) {
            if (this.gnP > this.gnQ) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bvz()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bvz() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.gnC.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.gnC.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
