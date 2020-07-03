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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
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
    private BdListView.e UJ;
    private com.baidu.tbadk.editortools.pb.b evF;
    private NoNetworkView.a flL;
    private NoNetworkView fns;
    private PbListView fnt;
    private g fwo;
    private View hCa;
    private BdTypeRecyclerView icy;
    private com.baidu.tieba.homepage.topic.topicdetail.a iyK;
    private ImageView iyL;
    private TopicDetailHeadView iyM;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b iyN;
    private View iyO;
    private View iyP;
    private TextView iyQ;
    private TextView iyR;
    private a iyS;
    private View iyT;
    private com.baidu.tieba.write.c iyU;
    private EditText iyV;
    private int iyW;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a iyX;
    a.RunnableC0640a iyY;
    private int iyZ;
    private int iza;
    private NewWriteModel.d izb;
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
        this.iyP = null;
        this.iyQ = null;
        this.iyR = null;
        this.mHasMore = true;
        this.iyZ = 0;
        this.iza = 44;
        this.flL = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.iyK != null) {
                    TopicDetailView.this.iyK.loadData();
                }
            }
        };
        this.evF = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bfy() {
                if (TopicDetailView.this.iyU.dqK()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.iyU.dqM());
                    TopicDetailView.this.oF(true);
                    return true;
                }
                return false;
            }
        };
        this.izb = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.iyS != null && TopicDetailView.this.iyS.bfa() != null) {
                    TopicDetailView.this.iyS.bfa().hide();
                }
                if (z) {
                    TopicDetailView.this.iyU.OM(null);
                    TopicDetailView.this.iyU.aY(null);
                    TopicDetailView.this.iyU.vE(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.iyY = TopicDetailView.this.iyX.B(j, j2);
                            com.baidu.adp.lib.f.e.lt().postDelayed(TopicDetailView.this.iyY, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.iyU.aY(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.iyU.OM(postWriteCallBackData.getErrorString());
                    if (!w.isEmpty(TopicDetailView.this.iyU.dqI())) {
                        TopicDetailView.this.oF(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.iyS != null) {
                    TopicDetailView.this.iyS.bgb();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.icy, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.iyZ += i2;
                TopicDetailView.this.ckK();
            }
        };
        this.UJ = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.buK();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).es(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).iym);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iyK = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.hCa == null) {
            this.hCa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hCa.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.hCa.findViewById(R.id.widget_navi_back_button);
        }
        this.iyL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aWQ().a(this.iyL, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        an.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.fns = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.fns.a(this.flL);
        this.iyP = findViewById(R.id.pb_editor_tool_comment);
        this.iyQ = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.iyQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.ckJ();
            }
        });
        this.iyR = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.iyO = findViewById(R.id.activity_topic_detail_editor);
        ar(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.iyS.bfa(), layoutParams);
        this.iyU = new com.baidu.tieba.write.c();
        this.iyT = findViewById(R.id.activity_topic_detail_editor_top);
        this.icy = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.icy.setLayoutManager(new LinearLayoutManager(getContext()));
        this.icy.setFadingEdgeLength(0);
        this.icy.setOverScrollMode(2);
        this.icy.setOnSrollToBottomListener(this.UJ);
        this.icy.addOnScrollListener(this.mScrollListener);
        an.setBackgroundColor(this.icy, R.color.cp_bg_line_d);
        this.iyN = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.icy);
        this.iyM = new TopicDetailHeadView(getContext());
        this.iyM.iyI.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void xt(int i) {
                TopicDetailView.this.xs(i);
            }
        });
        if (this.fwo == null) {
            this.fnt = new PbListView(this.mPageContext.getPageActivity());
            this.fnt.getView();
        }
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_e));
        this.fnt.setContainerBackgroundColorResId(an.getColor(R.color.cp_bg_line_d));
        this.fnt.setLineColorResource(an.getColor(R.color.cp_bg_line_c));
        this.fnt.setText(getResources().getString(R.string.list_has_no_more));
        this.fnt.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.iyX == null) {
            this.iyX = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.iyX.l(this.mPageContext.getUniqueId());
        }
    }

    private void ar(Bundle bundle) {
        this.iyS = (a) new b().dO(getContext());
        if (this.iyS != null) {
            this.iyS.a(this.mPageContext);
            this.iyS.b(this.izb);
            this.iyS.a(this.evF);
            this.iyS.bfa().m32if(true);
            this.iyS.bfa().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.iyS.a((BaseActivity) getContext(), bundle);
            this.iyS.bgb();
            this.iyS.bfa().setId(R.id.topic_editor);
            this.iyV = this.iyS.ckI().getInputView();
            this.iyV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.iyU != null) {
                        if (!TopicDetailView.this.iyU.dqL()) {
                            TopicDetailView.this.oF(false);
                        }
                        TopicDetailView.this.iyU.vF(false);
                    }
                }
            });
        }
    }

    public void oF(boolean z) {
        if (this.iyV != null && this.iyV.getText() != null) {
            int selectionEnd = this.iyV.getSelectionEnd();
            SpannableStringBuilder d = this.iyU.d(this.iyV.getText());
            if (d != null) {
                this.iyU.vF(true);
                this.iyV.setText(d);
                if (z && this.iyU.dqJ() >= 0) {
                    this.iyV.requestFocus();
                    this.iyV.setSelection(this.iyU.dqJ());
                } else {
                    this.iyV.setSelection(selectionEnd);
                }
                this.iyU.vE(this.iyU.dqJ() >= 0);
            }
        }
    }

    public void ckJ() {
        if (be.checkUpIsLogin(getContext())) {
            this.iyS.bge();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new ao("c13359").dk("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xs(int i) {
        this.iyW = i;
        this.iyR.setVisibility(0);
        if (i == 1) {
            this.iyR.setText(R.string.topic_detail_pk_support);
            an.setBackgroundResource(this.iyR, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.iyR.setText(R.string.topic_detail_pk_oppose);
            an.setBackgroundResource(this.iyR, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.iyR.setText(R.string.topic_detail_pk_chigua);
            an.setBackgroundResource(this.iyR, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.iyR.setTextColor(-2130706433);
        } else {
            an.setViewTextColor(this.iyR, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                buJ();
            } else if (!this.mHasMore) {
                buJ();
            } else {
                buI();
            }
            if (!StringUtils.isNull(aVar.dKw)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), ar.cutChineseAndEnglishWithSuffix(aVar.dKw, 14, StringHelper.STRING_MORE)));
            }
            this.iyM.setData(aVar.iye);
            this.icy.addHeaderView(this.iyM);
            this.iyN.setData(aVar.mDataList);
            if (this.mTopicDetailData.iye.iyj != null) {
                if (this.mTopicDetailData.iye.iyj.izD.izJ) {
                    xs(1);
                } else if (this.mTopicDetailData.iye.iyj.izE.izJ) {
                    xs(2);
                } else {
                    xs(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.iyR.setVisibility(8);
            }
            this.iyQ.setPadding(dimens, 0, 0, 0);
            ckK();
        }
    }

    public void setNextData(int i, boolean z, List<q> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            buJ();
        } else {
            buI();
        }
        if (i == 0 && list != null && !w.isEmpty(list)) {
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).iyo = this.mTopicDetailData.ckE();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.icy.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buK() {
        this.icy.setNextPage(null);
    }

    public void buI() {
        this.mHasMore = true;
        this.icy.setNextPage(this.fnt);
        this.fnt.startLoadData();
    }

    public void buJ() {
        this.icy.setNextPage(this.fnt);
        this.fnt.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hCa) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.iyL && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aYB();
            TiebaStatic.log(new ao("c13364").dk("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aYB() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.dKw;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.iyd) ? null : Uri.parse(this.mTopicDetailData.iyd);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.eny = true;
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
            ckK();
            an.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            an.setBackgroundResource(this.iyP, R.color.cp_bg_line_h);
            an.setViewTextColor(this.iyQ, (int) R.color.cp_cont_d);
            this.iyQ.setBackgroundDrawable(an.aG(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), an.getColor(R.color.cp_bg_line_j)));
            xs(this.iyW);
            SvgManager.aWQ().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.iyL != null) {
                SvgManager.aWQ().a(this.iyL, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.fns != null) {
                this.fns.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fwo != null) {
                this.fwo.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iyS != null && this.iyS.bfa() != null) {
                this.iyS.bfa().onChangeSkinType(this.mSkinType);
            }
            if (this.fnt != null) {
                this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
                this.fnt.setTextColor(an.getColor(R.color.cp_cont_e));
                this.fnt.setContainerBackgroundColorResId(an.getColor(R.color.cp_bg_line_d));
                this.fnt.setLineColorResource(an.getColor(R.color.cp_bg_line_c));
            }
            if (this.iyM != null) {
                this.iyM.onChangeSkinType();
            }
            if (this.iyN != null) {
                this.iyN.notifyDataSetChanged();
            }
            an.setBackgroundColor(this.icy, R.color.cp_bg_line_e);
        }
    }

    public void ga(boolean z) {
        if (!bSQ()) {
            if (this.fwo == null) {
                this.fwo = new g(getContext());
                this.fwo.onChangeSkinType();
            }
            this.fwo.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this);
            this.fwo = null;
        }
    }

    public boolean bSQ() {
        if (this.fwo != null) {
            return this.fwo.isViewAttached();
        }
        return false;
    }

    public void mB(boolean z) {
        if (!bSR()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.iyK != null) {
                            TopicDetailView.this.iyK.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.icy.setVisibility(8);
            SvgManager.aWQ().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void btN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.icy.setVisibility(0);
        SvgManager.aWQ().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bSR() {
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
        this.icy.setOnSrollToBottomListener(null);
        if (this.fns != null) {
            this.fns.b(this.flL);
        }
        if (this.iyS != null) {
            this.iyS.onDestory();
        }
        if (this.iyY != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iyY);
        }
        hideLoadingView();
        btN();
    }

    public a getEditor() {
        return this.iyS;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.iyT != null) {
            ViewGroup.LayoutParams layoutParams = this.iyT.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.iyS.bfa().isVisible()) {
                    layoutParams2.addRule(2, this.iyS.bfa().getId());
                } else {
                    layoutParams2.addRule(2, this.iyO.getId());
                }
                this.iyT.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aE(bu buVar) {
        int i;
        com.baidu.tieba.homepage.topic.topicdetail.b.c cVar;
        int i2 = 0;
        Iterator<q> it = this.mTopicDetailData.mDataList.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            q next = it.next();
            if (next instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                cVar = (com.baidu.tieba.homepage.topic.topicdetail.b.c) next;
                break;
            }
            i2 = i + 1;
        }
        if (cVar != null) {
            com.baidu.tieba.homepage.topic.topicdetail.b.c cVar2 = new com.baidu.tieba.homepage.topic.topicdetail.b.c();
            cVar2.iym = cVar.iym;
            cVar2.dLi = buVar;
            cVar2.source = 2;
            cVar2.iyn = this.iyW;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.iyo = this.mTopicDetailData.ckE();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.iyN.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckK() {
        if (this.mTopicDetailData != null && this.iyM != null) {
            if (this.iyZ > this.iza) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ckL()));
                return;
            }
            an.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap ckL() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.iyM.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.iyM.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
