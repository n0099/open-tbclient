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
    private BdListView.e Uf;
    private com.baidu.tbadk.editortools.pb.b emP;
    private NoNetworkView.a faq;
    private NoNetworkView fbX;
    private PbListView fbY;
    private g fkQ;
    private BdTypeRecyclerView hOz;
    private View hpf;
    private com.baidu.tieba.homepage.topic.topicdetail.a igS;
    private ImageView igT;
    private TopicDetailHeadView igU;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b igV;
    private View igW;
    private View igX;
    private TextView igY;
    private TextView igZ;
    private a iha;
    private View ihb;
    private com.baidu.tieba.write.c ihc;
    private EditText ihd;
    private int ihe;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a ihf;
    a.RunnableC0629a ihg;
    private int ihh;
    private int ihi;
    private NewWriteModel.d ihj;
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
        this.igX = null;
        this.igY = null;
        this.igZ = null;
        this.mHasMore = true;
        this.ihh = 0;
        this.ihi = 44;
        this.faq = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.igS != null) {
                    TopicDetailView.this.igS.loadData();
                }
            }
        };
        this.emP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bdt() {
                if (TopicDetailView.this.ihc.dmi()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.ihc.dmk());
                    TopicDetailView.this.ov(true);
                    return true;
                }
                return false;
            }
        };
        this.ihj = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.iha != null && TopicDetailView.this.iha.bcW() != null) {
                    TopicDetailView.this.iha.bcW().hide();
                }
                if (z) {
                    TopicDetailView.this.ihc.Of(null);
                    TopicDetailView.this.ihc.aX(null);
                    TopicDetailView.this.ihc.vl(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.ihg = TopicDetailView.this.ihf.C(j, j2);
                            com.baidu.adp.lib.f.e.ld().postDelayed(TopicDetailView.this.ihg, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.ihc.aX(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.ihc.Of(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.ihc.dmg())) {
                        TopicDetailView.this.ov(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.iha != null) {
                    TopicDetailView.this.iha.bdV();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.hOz, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.ihh += i2;
                TopicDetailView.this.cgP();
            }
        };
        this.Uf = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.brM();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).ep(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).igu);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.igS = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.hpf == null) {
            this.hpf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hpf.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.hpf.findViewById(R.id.widget_navi_back_button);
        }
        this.igT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aUV().a(this.igT, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.fbX = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.fbX.a(this.faq);
        this.igX = findViewById(R.id.pb_editor_tool_comment);
        this.igY = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.igY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cgO();
            }
        });
        this.igZ = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.igW = findViewById(R.id.activity_topic_detail_editor);
        aq(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.iha.bcW(), layoutParams);
        this.ihc = new com.baidu.tieba.write.c();
        this.ihb = findViewById(R.id.activity_topic_detail_editor_top);
        this.hOz = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.hOz.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hOz.setFadingEdgeLength(0);
        this.hOz.setOverScrollMode(2);
        this.hOz.setOnSrollToBottomListener(this.Uf);
        this.hOz.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.hOz, R.color.cp_bg_line_d);
        this.igV = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.hOz);
        this.igU = new TopicDetailHeadView(getContext());
        this.igU.igQ.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void wH(int i) {
                TopicDetailView.this.wG(i);
            }
        });
        if (this.fkQ == null) {
            this.fbY = new PbListView(this.mPageContext.getPageActivity());
            this.fbY.getView();
        }
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_e));
        this.fbY.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.fbY.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.fbY.setText(getResources().getString(R.string.list_has_no_more));
        this.fbY.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.ihf == null) {
            this.ihf = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.ihf.l(this.mPageContext.getUniqueId());
        }
    }

    private void aq(Bundle bundle) {
        this.iha = (a) new b().dN(getContext());
        if (this.iha != null) {
            this.iha.a(this.mPageContext);
            this.iha.b(this.ihj);
            this.iha.a(this.emP);
            this.iha.bcW().hW(true);
            this.iha.bcW().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.iha.a((BaseActivity) getContext(), bundle);
            this.iha.bdV();
            this.iha.bcW().setId(R.id.topic_editor);
            this.ihd = this.iha.cgN().getInputView();
            this.ihd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.ihc != null) {
                        if (!TopicDetailView.this.ihc.dmj()) {
                            TopicDetailView.this.ov(false);
                        }
                        TopicDetailView.this.ihc.vm(false);
                    }
                }
            });
        }
    }

    public void ov(boolean z) {
        if (this.ihd != null && this.ihd.getText() != null) {
            int selectionEnd = this.ihd.getSelectionEnd();
            SpannableStringBuilder a = this.ihc.a(this.ihd.getText());
            if (a != null) {
                this.ihc.vm(true);
                this.ihd.setText(a);
                if (z && this.ihc.dmh() >= 0) {
                    this.ihd.requestFocus();
                    this.ihd.setSelection(this.ihc.dmh());
                } else {
                    this.ihd.setSelection(selectionEnd);
                }
                this.ihc.vl(this.ihc.dmh() >= 0);
            }
        }
    }

    public void cgO() {
        if (bc.checkUpIsLogin(getContext())) {
            this.iha.bdY();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").dh("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wG(int i) {
        this.ihe = i;
        this.igZ.setVisibility(0);
        if (i == 1) {
            this.igZ.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.igZ, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.igZ.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.igZ, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.igZ.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.igZ, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.igZ.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.igZ, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                brL();
            } else if (!this.mHasMore) {
                brL();
            } else {
                brK();
            }
            if (!StringUtils.isNull(aVar.dDW)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.dDW, 14, StringHelper.STRING_MORE)));
            }
            this.igU.setData(aVar.igm);
            this.hOz.addHeaderView(this.igU);
            this.igV.setData(aVar.mDataList);
            if (this.mTopicDetailData.igm.igr != null) {
                if (this.mTopicDetailData.igm.igr.ihM.ihS) {
                    wG(1);
                } else if (this.mTopicDetailData.igm.igr.ihN.ihS) {
                    wG(2);
                } else {
                    wG(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.igZ.setVisibility(8);
            }
            this.igY.setPadding(dimens, 0, 0, 0);
            cgP();
        }
    }

    public void setNextData(int i, boolean z, List<o> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            brL();
        } else {
            brK();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (o oVar : list) {
                if (oVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) oVar).igw = this.mTopicDetailData.cgI();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.hOz.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brM() {
        this.hOz.setNextPage(null);
    }

    public void brK() {
        this.mHasMore = true;
        this.hOz.setNextPage(this.fbY);
        this.fbY.startLoadData();
    }

    public void brL() {
        this.hOz.setNextPage(this.fbY);
        this.fbY.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hpf) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.igT && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aWI();
            TiebaStatic.log(new an("c13364").dh("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aWI() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.dDW;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.igl) ? null : Uri.parse(this.mTopicDetailData.igl);
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
            cgP();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.igX, R.color.cp_bg_line_h);
            am.setViewTextColor(this.igY, (int) R.color.cp_cont_d);
            this.igY.setBackgroundDrawable(am.aE(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            wG(this.ihe);
            SvgManager.aUV().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.igT != null) {
                SvgManager.aUV().a(this.igT, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.fbX != null) {
                this.fbX.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fkQ != null) {
                this.fkQ.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iha != null && this.iha.bcW() != null) {
                this.iha.bcW().onChangeSkinType(this.mSkinType);
            }
            if (this.fbY != null) {
                this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
                this.fbY.setTextColor(am.getColor(R.color.cp_cont_e));
                this.fbY.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.fbY.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.igU != null) {
                this.igU.onChangeSkinType();
            }
            if (this.igV != null) {
                this.igV.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.hOz, R.color.cp_bg_line_e);
        }
    }

    public void fV(boolean z) {
        if (!bPL()) {
            if (this.fkQ == null) {
                this.fkQ = new g(getContext());
                this.fkQ.onChangeSkinType();
            }
            this.fkQ.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this);
            this.fkQ = null;
        }
    }

    public boolean bPL() {
        if (this.fkQ != null) {
            return this.fkQ.isViewAttached();
        }
        return false;
    }

    public void mq(boolean z) {
        if (!bPM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.igS != null) {
                            TopicDetailView.this.igS.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hOz.setVisibility(8);
            SvgManager.aUV().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bqO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.hOz.setVisibility(0);
        SvgManager.aUV().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bPM() {
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
        this.hOz.setOnSrollToBottomListener(null);
        if (this.fbX != null) {
            this.fbX.b(this.faq);
        }
        if (this.iha != null) {
            this.iha.onDestory();
        }
        if (this.ihg != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.ihg);
        }
        hideLoadingView();
        bqO();
    }

    public a getEditor() {
        return this.iha;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.ihb != null) {
            ViewGroup.LayoutParams layoutParams = this.ihb.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.iha.bcW().isVisible()) {
                    layoutParams2.addRule(2, this.iha.bcW().getId());
                } else {
                    layoutParams2.addRule(2, this.igW.getId());
                }
                this.ihb.setLayoutParams(layoutParams2);
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
            cVar2.igu = cVar.igu;
            cVar2.dEA = bkVar;
            cVar2.source = 2;
            cVar2.igv = this.ihe;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.igw = this.mTopicDetailData.cgI();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.igV.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgP() {
        if (this.mTopicDetailData != null && this.igU != null) {
            if (this.ihh > this.ihi) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cgQ()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cgQ() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.igU.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.igU.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
