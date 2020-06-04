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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tbadk.coreExtra.data.ab;
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
    private BdListView.e Uf;
    private com.baidu.tbadk.editortools.pb.b emP;
    private NoNetworkView.a faB;
    private NoNetworkView fci;
    private PbListView fcj;
    private g flb;
    private BdTypeRecyclerView hPm;
    private View hpq;
    private com.baidu.tieba.homepage.topic.topicdetail.a ihF;
    private ImageView ihG;
    private TopicDetailHeadView ihH;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b ihI;
    private View ihJ;
    private View ihK;
    private TextView ihL;
    private TextView ihM;
    private a ihN;
    private View ihO;
    private com.baidu.tieba.write.c ihP;
    private EditText ihQ;
    private int ihR;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a ihS;
    a.RunnableC0629a ihT;
    private int ihU;
    private int ihV;
    private NewWriteModel.d ihW;
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
        this.ihK = null;
        this.ihL = null;
        this.ihM = null;
        this.mHasMore = true;
        this.ihU = 0;
        this.ihV = 44;
        this.faB = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.ihF != null) {
                    TopicDetailView.this.ihF.loadData();
                }
            }
        };
        this.emP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bdu() {
                if (TopicDetailView.this.ihP.dmx()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.ihP.dmz());
                    TopicDetailView.this.ov(true);
                    return true;
                }
                return false;
            }
        };
        this.ihW = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.ihN != null && TopicDetailView.this.ihN.bcX() != null) {
                    TopicDetailView.this.ihN.bcX().hide();
                }
                if (z) {
                    TopicDetailView.this.ihP.Og(null);
                    TopicDetailView.this.ihP.aX(null);
                    TopicDetailView.this.ihP.vm(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.ihT = TopicDetailView.this.ihS.C(j, j2);
                            com.baidu.adp.lib.f.e.ld().postDelayed(TopicDetailView.this.ihT, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.ihP.aX(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.ihP.Og(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.ihP.dmv())) {
                        TopicDetailView.this.ov(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.ihN != null) {
                    TopicDetailView.this.ihN.bdW();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.hPm, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.ihU += i2;
                TopicDetailView.this.cgY();
            }
        };
        this.Uf = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.brO();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).ep(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).ihh);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.ihF = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.hpq == null) {
            this.hpq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hpq.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.hpq.findViewById(R.id.widget_navi_back_button);
        }
        this.ihG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aUW().a(this.ihG, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.fci = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.fci.a(this.faB);
        this.ihK = findViewById(R.id.pb_editor_tool_comment);
        this.ihL = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.ihL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cgX();
            }
        });
        this.ihM = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.ihJ = findViewById(R.id.activity_topic_detail_editor);
        aq(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.ihN.bcX(), layoutParams);
        this.ihP = new com.baidu.tieba.write.c();
        this.ihO = findViewById(R.id.activity_topic_detail_editor_top);
        this.hPm = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.hPm.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hPm.setFadingEdgeLength(0);
        this.hPm.setOverScrollMode(2);
        this.hPm.setOnSrollToBottomListener(this.Uf);
        this.hPm.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.hPm, R.color.cp_bg_line_d);
        this.ihI = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.hPm);
        this.ihH = new TopicDetailHeadView(getContext());
        this.ihH.ihD.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void wJ(int i) {
                TopicDetailView.this.wI(i);
            }
        });
        if (this.flb == null) {
            this.fcj = new PbListView(this.mPageContext.getPageActivity());
            this.fcj.getView();
        }
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_e));
        this.fcj.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.fcj.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.fcj.setText(getResources().getString(R.string.list_has_no_more));
        this.fcj.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.ihS == null) {
            this.ihS = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.ihS.l(this.mPageContext.getUniqueId());
        }
    }

    private void aq(Bundle bundle) {
        this.ihN = (a) new b().dN(getContext());
        if (this.ihN != null) {
            this.ihN.a(this.mPageContext);
            this.ihN.b(this.ihW);
            this.ihN.a(this.emP);
            this.ihN.bcX().hW(true);
            this.ihN.bcX().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.ihN.a((BaseActivity) getContext(), bundle);
            this.ihN.bdW();
            this.ihN.bcX().setId(R.id.topic_editor);
            this.ihQ = this.ihN.cgW().getInputView();
            this.ihQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.ihP != null) {
                        if (!TopicDetailView.this.ihP.dmy()) {
                            TopicDetailView.this.ov(false);
                        }
                        TopicDetailView.this.ihP.vn(false);
                    }
                }
            });
        }
    }

    public void ov(boolean z) {
        if (this.ihQ != null && this.ihQ.getText() != null) {
            int selectionEnd = this.ihQ.getSelectionEnd();
            SpannableStringBuilder a = this.ihP.a(this.ihQ.getText());
            if (a != null) {
                this.ihP.vn(true);
                this.ihQ.setText(a);
                if (z && this.ihP.dmw() >= 0) {
                    this.ihQ.requestFocus();
                    this.ihQ.setSelection(this.ihP.dmw());
                } else {
                    this.ihQ.setSelection(selectionEnd);
                }
                this.ihP.vm(this.ihP.dmw() >= 0);
            }
        }
    }

    public void cgX() {
        if (bc.checkUpIsLogin(getContext())) {
            this.ihN.bdZ();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").dh("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI(int i) {
        this.ihR = i;
        this.ihM.setVisibility(0);
        if (i == 1) {
            this.ihM.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.ihM, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.ihM.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.ihM, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.ihM.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.ihM, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.ihM.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.ihM, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                brN();
            } else if (!this.mHasMore) {
                brN();
            } else {
                brM();
            }
            if (!StringUtils.isNull(aVar.dDW)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.dDW, 14, StringHelper.STRING_MORE)));
            }
            this.ihH.setData(aVar.igZ);
            this.hPm.addHeaderView(this.ihH);
            this.ihI.setData(aVar.mDataList);
            if (this.mTopicDetailData.igZ.ihe != null) {
                if (this.mTopicDetailData.igZ.ihe.iiz.iiF) {
                    wI(1);
                } else if (this.mTopicDetailData.igZ.ihe.iiA.iiF) {
                    wI(2);
                } else {
                    wI(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.ihM.setVisibility(8);
            }
            this.ihL.setPadding(dimens, 0, 0, 0);
            cgY();
        }
    }

    public void setNextData(int i, boolean z, List<o> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            brN();
        } else {
            brM();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (o oVar : list) {
                if (oVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) oVar).ihj = this.mTopicDetailData.cgR();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.hPm.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brO() {
        this.hPm.setNextPage(null);
    }

    public void brM() {
        this.mHasMore = true;
        this.hPm.setNextPage(this.fcj);
        this.fcj.startLoadData();
    }

    public void brN() {
        this.hPm.setNextPage(this.fcj);
        this.fcj.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hpq) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.ihG && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aWJ();
            TiebaStatic.log(new an("c13364").dh("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aWJ() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.dDW;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.igY) ? null : Uri.parse(this.mTopicDetailData.igY);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.eeN = true;
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
            cgY();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.ihK, R.color.cp_bg_line_h);
            am.setViewTextColor(this.ihL, (int) R.color.cp_cont_d);
            this.ihL.setBackgroundDrawable(am.aE(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            wI(this.ihR);
            SvgManager.aUW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.ihG != null) {
                SvgManager.aUW().a(this.ihG, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.fci != null) {
                this.fci.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.flb != null) {
                this.flb.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.ihN != null && this.ihN.bcX() != null) {
                this.ihN.bcX().onChangeSkinType(this.mSkinType);
            }
            if (this.fcj != null) {
                this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
                this.fcj.setTextColor(am.getColor(R.color.cp_cont_e));
                this.fcj.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.fcj.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.ihH != null) {
                this.ihH.onChangeSkinType();
            }
            if (this.ihI != null) {
                this.ihI.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.hPm, R.color.cp_bg_line_e);
        }
    }

    public void fV(boolean z) {
        if (!bPN()) {
            if (this.flb == null) {
                this.flb = new g(getContext());
                this.flb.onChangeSkinType();
            }
            this.flb.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this);
            this.flb = null;
        }
    }

    public boolean bPN() {
        if (this.flb != null) {
            return this.flb.isViewAttached();
        }
        return false;
    }

    public void mq(boolean z) {
        if (!bPO()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.ihF != null) {
                            TopicDetailView.this.ihF.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hPm.setVisibility(8);
            SvgManager.aUW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bqQ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.hPm.setVisibility(0);
        SvgManager.aUW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bPO() {
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
        this.hPm.setOnSrollToBottomListener(null);
        if (this.fci != null) {
            this.fci.b(this.faB);
        }
        if (this.ihN != null) {
            this.ihN.onDestory();
        }
        if (this.ihT != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.ihT);
        }
        hideLoadingView();
        bqQ();
    }

    public a getEditor() {
        return this.ihN;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.ihO != null) {
            ViewGroup.LayoutParams layoutParams = this.ihO.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.ihN.bcX().isVisible()) {
                    layoutParams2.addRule(2, this.ihN.bcX().getId());
                } else {
                    layoutParams2.addRule(2, this.ihJ.getId());
                }
                this.ihO.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aE(bk bkVar) {
        int i;
        com.baidu.tieba.homepage.topic.topicdetail.b.c cVar;
        int i2 = 0;
        Iterator<o> it = this.mTopicDetailData.mDataList.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            o next = it.next();
            if (next instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                cVar = (com.baidu.tieba.homepage.topic.topicdetail.b.c) next;
                break;
            }
            i2 = i + 1;
        }
        if (cVar != null) {
            com.baidu.tieba.homepage.topic.topicdetail.b.c cVar2 = new com.baidu.tieba.homepage.topic.topicdetail.b.c();
            cVar2.ihh = cVar.ihh;
            cVar2.dEA = bkVar;
            cVar2.source = 2;
            cVar2.ihi = this.ihR;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.ihj = this.mTopicDetailData.cgR();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.ihI.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgY() {
        if (this.mTopicDetailData != null && this.ihH != null) {
            if (this.ihU > this.ihV) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cgZ()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cgZ() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.ihH.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.ihH.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
