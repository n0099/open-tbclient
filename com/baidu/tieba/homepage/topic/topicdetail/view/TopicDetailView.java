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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
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
/* loaded from: classes16.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e Vh;
    private com.baidu.tbadk.editortools.pb.b eMx;
    private NoNetworkView.a fCp;
    private NoNetworkView fDV;
    private PbListView fDW;
    private g fMN;
    private View hVo;
    private com.baidu.tieba.homepage.topic.topicdetail.a iTO;
    private ImageView iTP;
    private TopicDetailHeadView iTQ;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b iTR;
    private View iTS;
    private View iTT;
    private TextView iTU;
    private TextView iTV;
    private a iTW;
    private View iTX;
    private com.baidu.tieba.write.c iTY;
    private EditText iTZ;
    private int iUa;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a iUb;
    a.RunnableC0701a iUc;
    private int iUd;
    private int iUe;
    private NewWriteModel.d iUf;
    private BdTypeRecyclerView iwH;
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
        this.iTT = null;
        this.iTU = null;
        this.iTV = null;
        this.mHasMore = true;
        this.iUd = 0;
        this.iUe = 44;
        this.fCp = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.iTO != null) {
                    TopicDetailView.this.iTO.loadData();
                }
            }
        };
        this.eMx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean brU() {
                if (TopicDetailView.this.iTY.dFw()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.iTY.dFy());
                    TopicDetailView.this.pQ(true);
                    return true;
                }
                return false;
            }
        };
        this.iUf = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.iTW != null && TopicDetailView.this.iTW.brv() != null) {
                    TopicDetailView.this.iTW.brv().hide();
                }
                if (z) {
                    TopicDetailView.this.iTY.Sw(null);
                    TopicDetailView.this.iTY.bf(null);
                    TopicDetailView.this.iTY.wX(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.iUc = TopicDetailView.this.iUb.B(j, j2);
                            com.baidu.adp.lib.f.e.mS().postDelayed(TopicDetailView.this.iUc, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.iTY.bf(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.iTY.Sw(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.iTY.dFu())) {
                        TopicDetailView.this.pQ(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.iTW != null) {
                    TopicDetailView.this.iTW.bsy();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.iwH, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.iUd += i2;
                TopicDetailView.this.cze();
            }
        };
        this.Vh = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bGT();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).eR(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).iTq);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iTO = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.hVo == null) {
            this.hVo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hVo.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.hVo.findViewById(R.id.widget_navi_back_button);
        }
        this.iTP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.bjq().a(this.iTP, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.fDV = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.fDV.a(this.fCp);
        this.iTT = findViewById(R.id.pb_editor_tool_comment);
        this.iTU = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.iTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.czd();
            }
        });
        this.iTV = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.iTS = findViewById(R.id.activity_topic_detail_editor);
        ar(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.iTW.brv(), layoutParams);
        this.iTY = new com.baidu.tieba.write.c();
        this.iTX = findViewById(R.id.activity_topic_detail_editor_top);
        this.iwH = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.iwH.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iwH.setFadingEdgeLength(0);
        this.iwH.setOverScrollMode(2);
        this.iwH.setOnSrollToBottomListener(this.Vh);
        this.iwH.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.iwH, R.color.cp_bg_line_d);
        this.iTR = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.iwH);
        this.iTQ = new TopicDetailHeadView(getContext());
        this.iTQ.iTM.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void Af(int i) {
                TopicDetailView.this.Ae(i);
            }
        });
        if (this.fMN == null) {
            this.fDW = new PbListView(this.mPageContext.getPageActivity());
            this.fDW.getView();
        }
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_e));
        this.fDW.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
        this.fDW.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
        this.fDW.setText(getResources().getString(R.string.list_has_no_more));
        this.fDW.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.iUb == null) {
            this.iUb = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.iUb.m(this.mPageContext.getUniqueId());
        }
    }

    private void ar(Bundle bundle) {
        this.iTW = (a) new b().ec(getContext());
        if (this.iTW != null) {
            this.iTW.a(this.mPageContext);
            this.iTW.b(this.iUf);
            this.iTW.a(this.eMx);
            this.iTW.brv().jh(true);
            this.iTW.brv().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.iTW.a((BaseActivity) getContext(), bundle);
            this.iTW.bsy();
            this.iTW.brv().setId(R.id.topic_editor);
            this.iTZ = this.iTW.czc().getInputView();
            this.iTZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.iTY != null) {
                        if (!TopicDetailView.this.iTY.dFx()) {
                            TopicDetailView.this.pQ(false);
                        }
                        TopicDetailView.this.iTY.wY(false);
                    }
                }
            });
        }
    }

    public void pQ(boolean z) {
        if (this.iTZ != null && this.iTZ.getText() != null) {
            int selectionEnd = this.iTZ.getSelectionEnd();
            SpannableStringBuilder c = this.iTY.c(this.iTZ.getText());
            if (c != null) {
                this.iTY.wY(true);
                this.iTZ.setText(c);
                if (z && this.iTY.dFv() >= 0) {
                    this.iTZ.requestFocus();
                    this.iTZ.setSelection(this.iTY.dFv());
                } else {
                    this.iTZ.setSelection(selectionEnd);
                }
                this.iTY.wX(this.iTY.dFv() >= 0);
            }
        }
    }

    public void czd() {
        if (bg.checkUpIsLogin(getContext())) {
            this.iTW.bsB();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new aq("c13359").dD("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ae(int i) {
        this.iUa = i;
        this.iTV.setVisibility(0);
        if (i == 1) {
            this.iTV.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.iTV, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.iTV.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.iTV, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.iTV.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.iTV, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.iTV.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.iTV, R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bGS();
            } else if (!this.mHasMore) {
                bGS();
            } else {
                bGR();
            }
            if (!StringUtils.isNull(aVar.eab)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), at.cutChineseAndEnglishWithSuffix(aVar.eab, 14, StringHelper.STRING_MORE)));
            }
            this.iTQ.setData(aVar.iTi);
            this.iwH.addHeaderView(this.iTQ);
            this.iTR.setData(aVar.mDataList);
            if (this.mTopicDetailData.iTi.iTn != null) {
                if (this.mTopicDetailData.iTi.iTn.iUH.iUN) {
                    Ae(1);
                } else if (this.mTopicDetailData.iTi.iTn.iUI.iUN) {
                    Ae(2);
                } else {
                    Ae(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.iTV.setVisibility(8);
            }
            this.iTU.setPadding(dimens, 0, 0, 0);
            cze();
        }
    }

    public void setNextData(int i, boolean z, List<q> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bGS();
        } else {
            bGR();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).iTs = this.mTopicDetailData.cyY();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.iwH.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGT() {
        this.iwH.setNextPage(null);
    }

    public void bGR() {
        this.mHasMore = true;
        this.iwH.setNextPage(this.fDW);
        this.fDW.startLoadData();
    }

    public void bGS() {
        this.iwH.setNextPage(this.fDW);
        this.fDW.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hVo) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.iTP && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            bkV();
            TiebaStatic.log(new aq("c13364").dD("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void bkV() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.eab;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.iTh) ? null : Uri.parse(this.mTopicDetailData.iTh);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.eEi = true;
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
            cze();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
            ap.setBackgroundResource(this.iTT, R.color.cp_bg_line_h);
            ap.setViewTextColor(this.iTU, R.color.cp_cont_d);
            this.iTU.setBackgroundDrawable(ap.aO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
            Ae(this.iUa);
            SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.iTP != null) {
                SvgManager.bjq().a(this.iTP, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.fDV != null) {
                this.fDV.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fMN != null) {
                this.fMN.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iTW != null && this.iTW.brv() != null) {
                this.iTW.brv().onChangeSkinType(this.mSkinType);
            }
            if (this.fDW != null) {
                this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
                this.fDW.setTextColor(ap.getColor(R.color.cp_cont_e));
                this.fDW.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
                this.fDW.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
            }
            if (this.iTQ != null) {
                this.iTQ.onChangeSkinType();
            }
            if (this.iTR != null) {
                this.iTR.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.iwH, R.color.cp_bg_line_e);
        }
    }

    public void gS(boolean z) {
        if (!cgv()) {
            if (this.fMN == null) {
                this.fMN = new g(getContext());
                this.fMN.onChangeSkinType();
            }
            this.fMN.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this);
            this.fMN = null;
        }
    }

    public boolean cgv() {
        if (this.fMN != null) {
            return this.fMN.isViewAttached();
        }
        return false;
    }

    public void nK(boolean z) {
        if (!cgw()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.iTO != null) {
                            TopicDetailView.this.iTO.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.iwH.setVisibility(8);
            SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.iwH.setVisibility(0);
        SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cgw() {
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
        this.iwH.setOnSrollToBottomListener(null);
        if (this.fDV != null) {
            this.fDV.b(this.fCp);
        }
        if (this.iTW != null) {
            this.iTW.onDestory();
        }
        if (this.iUc != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iUc);
        }
        hideLoadingView();
        bFW();
    }

    public a getEditor() {
        return this.iTW;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.iTX != null) {
            ViewGroup.LayoutParams layoutParams = this.iTX.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.iTW.brv().isVisible()) {
                    layoutParams2.addRule(2, this.iTW.brv().getId());
                } else {
                    layoutParams2.addRule(2, this.iTS.getId());
                }
                this.iTX.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aC(bw bwVar) {
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
            cVar2.iTq = cVar.iTq;
            cVar2.dUS = bwVar;
            cVar2.source = 2;
            cVar2.iTr = this.iUa;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.iTs = this.mTopicDetailData.cyY();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.iTR.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cze() {
        if (this.mTopicDetailData != null && this.iTQ != null) {
            if (this.iUd > this.iUe) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(czf()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap czf() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.iTQ.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.iTQ.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
