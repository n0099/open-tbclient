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
import com.baidu.tbadk.coreExtra.data.z;
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
/* loaded from: classes7.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e Ah;
    private com.baidu.tbadk.editortools.pb.b dun;
    private NoNetworkView ehd;
    private PbListView ehe;
    private g epL;
    private NoNetworkView.a fWI;
    private BdTypeRecyclerView gMn;
    private View goa;
    private com.baidu.tieba.homepage.topic.topicdetail.a heE;
    private ImageView heF;
    private TopicDetailHeadView heG;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b heH;
    private View heI;
    private View heJ;
    private TextView heK;
    private TextView heL;
    private a heM;
    private View heN;
    private com.baidu.tieba.write.c heO;
    private EditText heP;
    private int heQ;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a heR;
    a.RunnableC0513a heS;
    private int heT;
    private int heU;
    private NewWriteModel.d heV;
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
        this.heJ = null;
        this.heK = null;
        this.heL = null;
        this.mHasMore = true;
        this.heT = 0;
        this.heU = 44;
        this.fWI = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.heE != null) {
                    TopicDetailView.this.heE.loadData();
                }
            }
        };
        this.dun = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean aMs() {
                if (TopicDetailView.this.heO.cSM()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.heO.cSO());
                    TopicDetailView.this.mN(true);
                    return true;
                }
                return false;
            }
        };
        this.heV = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.heM != null && TopicDetailView.this.heM.aLV() != null) {
                    TopicDetailView.this.heM.aLV().hide();
                }
                if (z) {
                    TopicDetailView.this.heO.Kx(null);
                    TopicDetailView.this.heO.aV(null);
                    TopicDetailView.this.heO.tC(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.heS = TopicDetailView.this.heR.A(j, j2);
                            com.baidu.adp.lib.f.e.gx().postDelayed(TopicDetailView.this.heS, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.heO.aV(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.heO.Kx(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.heO.cSK())) {
                        TopicDetailView.this.mN(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.heM != null) {
                    TopicDetailView.this.heM.aMU();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.gMn, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.heT += i2;
                TopicDetailView.this.bNU();
            }
        };
        this.Ah = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bbc();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dE(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).hef);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.heE = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.goa == null) {
            this.goa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.goa.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.goa.findViewById(R.id.widget_navi_back_button);
        }
        this.heF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aEp().a(this.heF, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.ehd = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.ehd.a(this.fWI);
        this.heJ = findViewById(R.id.pb_editor_tool_comment);
        this.heK = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.heK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bNT();
            }
        });
        this.heL = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.heI = findViewById(R.id.activity_topic_detail_editor);
        ak(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.heM.aLV(), layoutParams);
        this.heO = new com.baidu.tieba.write.c();
        this.heN = findViewById(R.id.activity_topic_detail_editor_top);
        this.gMn = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.gMn.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gMn.setFadingEdgeLength(0);
        this.gMn.setOverScrollMode(2);
        this.gMn.setOnSrollToBottomListener(this.Ah);
        this.gMn.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.gMn, R.color.cp_bg_line_d);
        this.heH = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.gMn);
        this.heG = new TopicDetailHeadView(getContext());
        this.heG.heC.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void vp(int i) {
                TopicDetailView.this.vo(i);
            }
        });
        if (this.epL == null) {
            this.ehe = new PbListView(this.mPageContext.getPageActivity());
            this.ehe.getView();
        }
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_e));
        this.ehe.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.ehe.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.ehe.setText(getResources().getString(R.string.list_has_no_more));
        this.ehe.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.heR == null) {
            this.heR = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.heR.j(this.mPageContext.getUniqueId());
        }
    }

    private void ak(Bundle bundle) {
        this.heM = (a) new b().dR(getContext());
        if (this.heM != null) {
            this.heM.a(this.mPageContext);
            this.heM.b(this.heV);
            this.heM.a(this.dun);
            this.heM.aLV().gu(true);
            this.heM.aLV().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.heM.a((BaseActivity) getContext(), bundle);
            this.heM.aMU();
            this.heM.aLV().setId(R.id.topic_editor);
            this.heP = this.heM.bNS().getInputView();
            this.heP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.heO != null) {
                        if (!TopicDetailView.this.heO.cSN()) {
                            TopicDetailView.this.mN(false);
                        }
                        TopicDetailView.this.heO.tD(false);
                    }
                }
            });
        }
    }

    public void mN(boolean z) {
        if (this.heP != null && this.heP.getText() != null) {
            int selectionEnd = this.heP.getSelectionEnd();
            SpannableStringBuilder a = this.heO.a(this.heP.getText());
            if (a != null) {
                this.heO.tD(true);
                this.heP.setText(a);
                if (z && this.heO.cSL() >= 0) {
                    this.heP.requestFocus();
                    this.heP.setSelection(this.heO.cSL());
                } else {
                    this.heP.setSelection(selectionEnd);
                }
                this.heO.tC(this.heO.cSL() >= 0);
            }
        }
    }

    public void bNT() {
        if (bc.checkUpIsLogin(getContext())) {
            this.heM.aMX();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").cp("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vo(int i) {
        this.heQ = i;
        this.heL.setVisibility(0);
        if (i == 1) {
            this.heL.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.heL, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.heL.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.heL, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.heL.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.heL, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.heL.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.heL, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bbb();
            } else if (!this.mHasMore) {
                bbb();
            } else {
                bba();
            }
            if (!StringUtils.isNull(aVar.cMx)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.cMx, 14, StringHelper.STRING_MORE)));
            }
            this.heG.setData(aVar.hdX);
            this.gMn.addHeaderView(this.heG);
            this.heH.setData(aVar.mDataList);
            if (this.mTopicDetailData.hdX.hec != null) {
                if (this.mTopicDetailData.hdX.hec.hfy.hfE) {
                    vo(1);
                } else if (this.mTopicDetailData.hdX.hec.hfz.hfE) {
                    vo(2);
                } else {
                    vo(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.heL.setVisibility(8);
            }
            this.heK.setPadding(dimens, 0, 0, 0);
            bNU();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bbb();
        } else {
            bba();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).heh = this.mTopicDetailData.bNN();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.gMn.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbc() {
        this.gMn.setNextPage(null);
    }

    public void bba() {
        this.mHasMore = true;
        this.gMn.setNextPage(this.ehe);
        this.ehe.startLoadData();
    }

    public void bbb() {
        this.gMn.setNextPage(this.ehe);
        this.ehe.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.goa) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.heF && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aFL();
            TiebaStatic.log(new an("c13364").cp("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aFL() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.cMx;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.hdW) ? null : Uri.parse(this.mTopicDetailData.hdW);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.dlM = true;
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
            bNU();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.heJ, R.color.cp_bg_line_h);
            am.setViewTextColor(this.heK, (int) R.color.cp_cont_d);
            this.heK.setBackgroundDrawable(am.ay(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            vo(this.heQ);
            SvgManager.aEp().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.heF != null) {
                SvgManager.aEp().a(this.heF, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.ehd != null) {
                this.ehd.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.epL != null) {
                this.epL.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.heM != null && this.heM.aLV() != null) {
                this.heM.aLV().onChangeSkinType(this.mSkinType);
            }
            if (this.ehe != null) {
                this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
                this.ehe.setTextColor(am.getColor(R.color.cp_cont_e));
                this.ehe.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.ehe.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.heG != null) {
                this.heG.onChangeSkinType();
            }
            if (this.heH != null) {
                this.heH.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.gMn, R.color.cp_bg_line_e);
        }
    }

    public void eF(boolean z) {
        if (!bxG()) {
            if (this.epL == null) {
                this.epL = new g(getContext());
                this.epL.onChangeSkinType();
            }
            this.epL.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this);
            this.epL = null;
        }
    }

    public boolean bxG() {
        if (this.epL != null) {
            return this.epL.isViewAttached();
        }
        return false;
    }

    public void kJ(boolean z) {
        if (!bxH()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.heE != null) {
                            TopicDetailView.this.heE.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gMn.setVisibility(8);
            SvgManager.aEp().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void baf() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.gMn.setVisibility(0);
        SvgManager.aEp().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bxH() {
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
        this.gMn.setOnSrollToBottomListener(null);
        if (this.ehd != null) {
            this.ehd.b(this.fWI);
        }
        if (this.heM != null) {
            this.heM.onDestory();
        }
        if (this.heS != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.heS);
        }
        hideLoadingView();
        baf();
    }

    public a getEditor() {
        return this.heM;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.heN != null) {
            ViewGroup.LayoutParams layoutParams = this.heN.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.heM.aLV().isVisible()) {
                    layoutParams2.addRule(2, this.heM.aLV().getId());
                } else {
                    layoutParams2.addRule(2, this.heI.getId());
                }
                this.heN.setLayoutParams(layoutParams2);
            }
        }
    }

    public void ay(bj bjVar) {
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
            cVar2.hef = cVar.hef;
            cVar2.cNb = bjVar;
            cVar2.source = 2;
            cVar2.heg = this.heQ;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.heh = this.mTopicDetailData.bNN();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.heH.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNU() {
        if (this.mTopicDetailData != null && this.heG != null) {
            if (this.heT > this.heU) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bNV()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bNV() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.heG.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.heG.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
