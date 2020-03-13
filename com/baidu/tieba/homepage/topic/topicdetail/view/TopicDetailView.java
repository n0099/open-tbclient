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
    private com.baidu.tbadk.editortools.pb.b dyH;
    private NoNetworkView elv;
    private PbListView elw;
    private g euk;
    private NoNetworkView.a fYY;
    private BdTypeRecyclerView gOA;
    private View gqq;
    private com.baidu.tieba.homepage.topic.topicdetail.a hgS;
    private ImageView hgT;
    private TopicDetailHeadView hgU;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b hgV;
    private View hgW;
    private View hgX;
    private TextView hgY;
    private TextView hgZ;
    private a hha;
    private View hhb;
    private com.baidu.tieba.write.c hhc;
    private EditText hhd;
    private int hhe;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a hhf;
    a.RunnableC0520a hhg;
    private int hhh;
    private int hhi;
    private NewWriteModel.d hhj;
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
        this.hgX = null;
        this.hgY = null;
        this.hgZ = null;
        this.mHasMore = true;
        this.hhh = 0;
        this.hhi = 44;
        this.fYY = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.hgS != null) {
                    TopicDetailView.this.hgS.loadData();
                }
            }
        };
        this.dyH = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean aOR() {
                if (TopicDetailView.this.hhc.cUf()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.hhc.cUh());
                    TopicDetailView.this.mP(true);
                    return true;
                }
                return false;
            }
        };
        this.hhj = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.hha != null && TopicDetailView.this.hha.aOu() != null) {
                    TopicDetailView.this.hha.aOu().hide();
                }
                if (z) {
                    TopicDetailView.this.hhc.KL(null);
                    TopicDetailView.this.hhc.aU(null);
                    TopicDetailView.this.hhc.tG(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.hhg = TopicDetailView.this.hhf.A(j, j2);
                            com.baidu.adp.lib.f.e.gx().postDelayed(TopicDetailView.this.hhg, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.hhc.aU(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.hhc.KL(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.hhc.cUd())) {
                        TopicDetailView.this.mP(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.hha != null) {
                    TopicDetailView.this.hha.aPt();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.gOA, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.hhh += i2;
                TopicDetailView.this.bPz();
            }
        };
        this.Az = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bdu();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dE(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).hgu);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hgS = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.gqq == null) {
            this.gqq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gqq.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.gqq.findViewById(R.id.widget_navi_back_button);
        }
        this.hgT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aGC().a(this.hgT, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.elv = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.elv.a(this.fYY);
        this.hgX = findViewById(R.id.pb_editor_tool_comment);
        this.hgY = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.hgY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bPy();
            }
        });
        this.hgZ = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.hgW = findViewById(R.id.activity_topic_detail_editor);
        ak(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.hha.aOu(), layoutParams);
        this.hhc = new com.baidu.tieba.write.c();
        this.hhb = findViewById(R.id.activity_topic_detail_editor_top);
        this.gOA = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.gOA.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gOA.setFadingEdgeLength(0);
        this.gOA.setOverScrollMode(2);
        this.gOA.setOnSrollToBottomListener(this.Az);
        this.gOA.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.gOA, R.color.cp_bg_line_d);
        this.hgV = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.gOA);
        this.hgU = new TopicDetailHeadView(getContext());
        this.hgU.hgQ.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void vv(int i) {
                TopicDetailView.this.vu(i);
            }
        });
        if (this.euk == null) {
            this.elw = new PbListView(this.mPageContext.getPageActivity());
            this.elw.getView();
        }
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elw.setTextColor(am.getColor(R.color.cp_cont_e));
        this.elw.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.elw.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.elw.setText(getResources().getString(R.string.list_has_no_more));
        this.elw.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.hhf == null) {
            this.hhf = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.hhf.j(this.mPageContext.getUniqueId());
        }
    }

    private void ak(Bundle bundle) {
        this.hha = (a) new b().dV(getContext());
        if (this.hha != null) {
            this.hha.a(this.mPageContext);
            this.hha.b(this.hhj);
            this.hha.a(this.dyH);
            this.hha.aOu().gB(true);
            this.hha.aOu().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.hha.a((BaseActivity) getContext(), bundle);
            this.hha.aPt();
            this.hha.aOu().setId(R.id.topic_editor);
            this.hhd = this.hha.bPx().getInputView();
            this.hhd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.hhc != null) {
                        if (!TopicDetailView.this.hhc.cUg()) {
                            TopicDetailView.this.mP(false);
                        }
                        TopicDetailView.this.hhc.tH(false);
                    }
                }
            });
        }
    }

    public void mP(boolean z) {
        if (this.hhd != null && this.hhd.getText() != null) {
            int selectionEnd = this.hhd.getSelectionEnd();
            SpannableStringBuilder a = this.hhc.a(this.hhd.getText());
            if (a != null) {
                this.hhc.tH(true);
                this.hhd.setText(a);
                if (z && this.hhc.cUe() >= 0) {
                    this.hhd.requestFocus();
                    this.hhd.setSelection(this.hhc.cUe());
                } else {
                    this.hhd.setSelection(selectionEnd);
                }
                this.hhc.tG(this.hhc.cUe() >= 0);
            }
        }
    }

    public void bPy() {
        if (bc.checkUpIsLogin(getContext())) {
            this.hha.aPw();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").cy("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(int i) {
        this.hhe = i;
        this.hgZ.setVisibility(0);
        if (i == 1) {
            this.hgZ.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.hgZ, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.hgZ.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.hgZ, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.hgZ.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.hgZ, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.hgZ.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.hgZ, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bdt();
            } else if (!this.mHasMore) {
                bdt();
            } else {
                bds();
            }
            if (!StringUtils.isNull(aVar.cQC)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.cQC, 14, StringHelper.STRING_MORE)));
            }
            this.hgU.setData(aVar.hgm);
            this.gOA.addHeaderView(this.hgU);
            this.hgV.setData(aVar.mDataList);
            if (this.mTopicDetailData.hgm.hgr != null) {
                if (this.mTopicDetailData.hgm.hgr.hhM.hhS) {
                    vu(1);
                } else if (this.mTopicDetailData.hgm.hgr.hhN.hhS) {
                    vu(2);
                } else {
                    vu(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.hgZ.setVisibility(8);
            }
            this.hgY.setPadding(dimens, 0, 0, 0);
            bPz();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bdt();
        } else {
            bds();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).hgw = this.mTopicDetailData.bPs();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.gOA.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdu() {
        this.gOA.setNextPage(null);
    }

    public void bds() {
        this.mHasMore = true;
        this.gOA.setNextPage(this.elw);
        this.elw.startLoadData();
    }

    public void bdt() {
        this.gOA.setNextPage(this.elw);
        this.elw.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gqq) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hgT && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aId();
            TiebaStatic.log(new an("c13364").cy("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aId() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.cQC;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.hgl) ? null : Uri.parse(this.mTopicDetailData.hgl);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.dqi = true;
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
            bPz();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.hgX, R.color.cp_bg_line_h);
            am.setViewTextColor(this.hgY, (int) R.color.cp_cont_d);
            this.hgY.setBackgroundDrawable(am.ay(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            vu(this.hhe);
            SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.hgT != null) {
                SvgManager.aGC().a(this.hgT, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.elv != null) {
                this.elv.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.euk != null) {
                this.euk.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hha != null && this.hha.aOu() != null) {
                this.hha.aOu().onChangeSkinType(this.mSkinType);
            }
            if (this.elw != null) {
                this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
                this.elw.setTextColor(am.getColor(R.color.cp_cont_e));
                this.elw.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.elw.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.hgU != null) {
                this.hgU.onChangeSkinType();
            }
            if (this.hgV != null) {
                this.hgV.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.gOA, R.color.cp_bg_line_e);
        }
    }

    public void eM(boolean z) {
        if (!bzl()) {
            if (this.euk == null) {
                this.euk = new g(getContext());
                this.euk.onChangeSkinType();
            }
            this.euk.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.euk != null) {
            this.euk.dettachView(this);
            this.euk = null;
        }
    }

    public boolean bzl() {
        if (this.euk != null) {
            return this.euk.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.hgS != null) {
                            TopicDetailView.this.hgS.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gOA.setVisibility(8);
            SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bcy() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.gOA.setVisibility(0);
        SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bzm() {
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
        this.gOA.setOnSrollToBottomListener(null);
        if (this.elv != null) {
            this.elv.b(this.fYY);
        }
        if (this.hha != null) {
            this.hha.onDestory();
        }
        if (this.hhg != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hhg);
        }
        hideLoadingView();
        bcy();
    }

    public a getEditor() {
        return this.hha;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.hhb != null) {
            ViewGroup.LayoutParams layoutParams = this.hhb.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.hha.aOu().isVisible()) {
                    layoutParams2.addRule(2, this.hha.aOu().getId());
                } else {
                    layoutParams2.addRule(2, this.hgW.getId());
                }
                this.hhb.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aC(bj bjVar) {
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
            cVar2.hgu = cVar.hgu;
            cVar2.cRg = bjVar;
            cVar2.source = 2;
            cVar2.hgv = this.hhe;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.hgw = this.mTopicDetailData.bPs();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.hgV.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPz() {
        if (this.mTopicDetailData != null && this.hgU != null) {
            if (this.hhh > this.hhi) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bPA()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bPA() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.hgU.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.hgU.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
