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
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e Az;
    private com.baidu.tbadk.editortools.pb.b dyU;
    private NoNetworkView elL;
    private PbListView elM;
    private g euG;
    private NoNetworkView.a fZG;
    private BdTypeRecyclerView gPH;
    private View gra;
    private TextView hiA;
    private a hiB;
    private View hiC;
    private com.baidu.tieba.write.c hiD;
    private EditText hiE;
    private int hiF;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a hiG;
    a.RunnableC0521a hiH;
    private int hiI;
    private int hiJ;
    private NewWriteModel.d hiK;
    private com.baidu.tieba.homepage.topic.topicdetail.a hit;
    private ImageView hiu;
    private TopicDetailHeadView hiv;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b hiw;
    private View hix;
    private View hiy;
    private TextView hiz;
    private ImageView mBackImageView;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private int mSkinType;
    private com.baidu.tieba.homepage.topic.topicdetail.b.a mTopicDetailData;

    public TopicDetailView(TbPageContext<?> tbPageContext, com.baidu.tieba.homepage.topic.topicdetail.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.hiy = null;
        this.hiz = null;
        this.hiA = null;
        this.mHasMore = true;
        this.hiI = 0;
        this.hiJ = 44;
        this.fZG = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.hit != null) {
                    TopicDetailView.this.hit.loadData();
                }
            }
        };
        this.dyU = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean aOV() {
                if (TopicDetailView.this.hiD.cUz()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.hiD.cUB());
                    TopicDetailView.this.mV(true);
                    return true;
                }
                return false;
            }
        };
        this.hiK = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.hiB != null && TopicDetailView.this.hiB.aOy() != null) {
                    TopicDetailView.this.hiB.aOy().hide();
                }
                if (z) {
                    TopicDetailView.this.hiD.KL(null);
                    TopicDetailView.this.hiD.aU(null);
                    TopicDetailView.this.hiD.tN(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.hiH = TopicDetailView.this.hiG.A(j, j2);
                            com.baidu.adp.lib.f.e.gx().postDelayed(TopicDetailView.this.hiH, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.hiD.aU(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.hiD.KL(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.hiD.cUx())) {
                        TopicDetailView.this.mV(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.hiB != null) {
                    TopicDetailView.this.hiB.aPx();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.gPH, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.hiI += i2;
                TopicDetailView.this.bPR();
            }
        };
        this.Az = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bdz();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dF(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).hhU);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hit = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.gra == null) {
            this.gra = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gra.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.gra.findViewById(R.id.widget_navi_back_button);
        }
        this.hiu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aGG().a(this.hiu, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.elL = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.elL.a(this.fZG);
        this.hiy = findViewById(R.id.pb_editor_tool_comment);
        this.hiz = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.hiz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bPQ();
            }
        });
        this.hiA = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.hix = findViewById(R.id.activity_topic_detail_editor);
        ak(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.hiB.aOy(), layoutParams);
        this.hiD = new com.baidu.tieba.write.c();
        this.hiC = findViewById(R.id.activity_topic_detail_editor_top);
        this.gPH = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.gPH.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gPH.setFadingEdgeLength(0);
        this.gPH.setOverScrollMode(2);
        this.gPH.setOnSrollToBottomListener(this.Az);
        this.gPH.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.gPH, R.color.cp_bg_line_d);
        this.hiw = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.gPH);
        this.hiv = new TopicDetailHeadView(getContext());
        this.hiv.hir.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void vD(int i) {
                TopicDetailView.this.vC(i);
            }
        });
        if (this.euG == null) {
            this.elM = new PbListView(this.mPageContext.getPageActivity());
            this.elM.getView();
        }
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elM.setTextColor(am.getColor(R.color.cp_cont_e));
        this.elM.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.elM.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.elM.setText(getResources().getString(R.string.list_has_no_more));
        this.elM.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.hiG == null) {
            this.hiG = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.hiG.j(this.mPageContext.getUniqueId());
        }
    }

    private void ak(Bundle bundle) {
        this.hiB = (a) new b().dU(getContext());
        if (this.hiB != null) {
            this.hiB.a(this.mPageContext);
            this.hiB.b(this.hiK);
            this.hiB.a(this.dyU);
            this.hiB.aOy().gC(true);
            this.hiB.aOy().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.hiB.a((BaseActivity) getContext(), bundle);
            this.hiB.aPx();
            this.hiB.aOy().setId(R.id.topic_editor);
            this.hiE = this.hiB.bPP().getInputView();
            this.hiE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.hiD != null) {
                        if (!TopicDetailView.this.hiD.cUA()) {
                            TopicDetailView.this.mV(false);
                        }
                        TopicDetailView.this.hiD.tO(false);
                    }
                }
            });
        }
    }

    public void mV(boolean z) {
        if (this.hiE != null && this.hiE.getText() != null) {
            int selectionEnd = this.hiE.getSelectionEnd();
            SpannableStringBuilder a = this.hiD.a(this.hiE.getText());
            if (a != null) {
                this.hiD.tO(true);
                this.hiE.setText(a);
                if (z && this.hiD.cUy() >= 0) {
                    this.hiE.requestFocus();
                    this.hiE.setSelection(this.hiD.cUy());
                } else {
                    this.hiE.setSelection(selectionEnd);
                }
                this.hiD.tN(this.hiD.cUy() >= 0);
            }
        }
    }

    public void bPQ() {
        if (bc.checkUpIsLogin(getContext())) {
            this.hiB.aPA();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").cx("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vC(int i) {
        this.hiF = i;
        this.hiA.setVisibility(0);
        if (i == 1) {
            this.hiA.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.hiA, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.hiA.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.hiA, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.hiA.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.hiA, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.hiA.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.hiA, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bdy();
            } else if (!this.mHasMore) {
                bdy();
            } else {
                bdx();
            }
            if (!StringUtils.isNull(aVar.cQP)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.cQP, 14, StringHelper.STRING_MORE)));
            }
            this.hiv.setData(aVar.hhM);
            this.gPH.addHeaderView(this.hiv);
            this.hiw.setData(aVar.mDataList);
            if (this.mTopicDetailData.hhM.hhR != null) {
                if (this.mTopicDetailData.hhM.hhR.hjn.hjt) {
                    vC(1);
                } else if (this.mTopicDetailData.hhM.hhR.hjo.hjt) {
                    vC(2);
                } else {
                    vC(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.hiA.setVisibility(8);
            }
            this.hiz.setPadding(dimens, 0, 0, 0);
            bPR();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bdy();
        } else {
            bdx();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).hhW = this.mTopicDetailData.bPK();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.gPH.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdz() {
        this.gPH.setNextPage(null);
    }

    public void bdx() {
        this.mHasMore = true;
        this.gPH.setNextPage(this.elM);
        this.elM.startLoadData();
    }

    public void bdy() {
        this.gPH.setNextPage(this.elM);
        this.elM.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gra) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hiu && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aIh();
            TiebaStatic.log(new an("c13364").cx("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aIh() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.cQP;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.hhL) ? null : Uri.parse(this.mTopicDetailData.hhL);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.dqv = true;
            shareItem.extData = valueOf;
            shareItem.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
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
            bPR();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.hiy, R.color.cp_bg_line_h);
            am.setViewTextColor(this.hiz, (int) R.color.cp_cont_d);
            this.hiz.setBackgroundDrawable(am.ay(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            vC(this.hiF);
            SvgManager.aGG().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.hiu != null) {
                SvgManager.aGG().a(this.hiu, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.elL != null) {
                this.elL.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.euG != null) {
                this.euG.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hiB != null && this.hiB.aOy() != null) {
                this.hiB.aOy().onChangeSkinType(this.mSkinType);
            }
            if (this.elM != null) {
                this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
                this.elM.setTextColor(am.getColor(R.color.cp_cont_e));
                this.elM.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.elM.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.hiv != null) {
                this.hiv.onChangeSkinType();
            }
            if (this.hiw != null) {
                this.hiw.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.gPH, R.color.cp_bg_line_e);
        }
    }

    public void eN(boolean z) {
        if (!bzr()) {
            if (this.euG == null) {
                this.euG = new g(getContext());
                this.euG.onChangeSkinType();
            }
            this.euG.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this);
            this.euG = null;
        }
    }

    public boolean bzr() {
        if (this.euG != null) {
            return this.euG.isViewAttached();
        }
        return false;
    }

    public void kS(boolean z) {
        if (!bzs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.hit != null) {
                            TopicDetailView.this.hit.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gPH.setVisibility(8);
            SvgManager.aGG().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bcC() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.gPH.setVisibility(0);
        SvgManager.aGG().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bzs() {
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
        this.gPH.setOnSrollToBottomListener(null);
        if (this.elL != null) {
            this.elL.b(this.fZG);
        }
        if (this.hiB != null) {
            this.hiB.onDestory();
        }
        if (this.hiH != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hiH);
        }
        hideLoadingView();
        bcC();
    }

    public a getEditor() {
        return this.hiB;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.hiC != null) {
            ViewGroup.LayoutParams layoutParams = this.hiC.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.hiB.aOy().isVisible()) {
                    layoutParams2.addRule(2, this.hiB.aOy().getId());
                } else {
                    layoutParams2.addRule(2, this.hix.getId());
                }
                this.hiC.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aD(bj bjVar) {
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
            cVar2.hhU = cVar.hhU;
            cVar2.cRt = bjVar;
            cVar2.source = 2;
            cVar2.hhV = this.hiF;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.hhW = this.mTopicDetailData.bPK();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.hiw.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPR() {
        if (this.mTopicDetailData != null && this.hiv != null) {
            if (this.hiI > this.hiJ) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bPS()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bPS() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.hiv.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.hiv.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
