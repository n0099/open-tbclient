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
    private com.baidu.tbadk.editortools.pb.b dyt;
    private NoNetworkView elh;
    private PbListView eli;
    private g etW;
    private NoNetworkView.a fYJ;
    private BdTypeRecyclerView gOm;
    private View gqb;
    private com.baidu.tieba.homepage.topic.topicdetail.a hgE;
    private ImageView hgF;
    private TopicDetailHeadView hgG;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b hgH;
    private View hgI;
    private View hgJ;
    private TextView hgK;
    private TextView hgL;
    private a hgM;
    private View hgN;
    private com.baidu.tieba.write.c hgO;
    private EditText hgP;
    private int hgQ;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a hgR;
    a.RunnableC0520a hgS;
    private int hgT;
    private int hgU;
    private NewWriteModel.d hgV;
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
        this.hgJ = null;
        this.hgK = null;
        this.hgL = null;
        this.mHasMore = true;
        this.hgT = 0;
        this.hgU = 44;
        this.fYJ = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.hgE != null) {
                    TopicDetailView.this.hgE.loadData();
                }
            }
        };
        this.dyt = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean aOO() {
                if (TopicDetailView.this.hgO.cUc()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.hgO.cUe());
                    TopicDetailView.this.mP(true);
                    return true;
                }
                return false;
            }
        };
        this.hgV = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.hgM != null && TopicDetailView.this.hgM.aOr() != null) {
                    TopicDetailView.this.hgM.aOr().hide();
                }
                if (z) {
                    TopicDetailView.this.hgO.KK(null);
                    TopicDetailView.this.hgO.aU(null);
                    TopicDetailView.this.hgO.tG(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.hgS = TopicDetailView.this.hgR.A(j, j2);
                            com.baidu.adp.lib.f.e.gx().postDelayed(TopicDetailView.this.hgS, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.hgO.aU(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.hgO.KK(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.hgO.cUa())) {
                        TopicDetailView.this.mP(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.hgM != null) {
                    TopicDetailView.this.hgM.aPq();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.gOm, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.hgT += i2;
                TopicDetailView.this.bPw();
            }
        };
        this.Az = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bdr();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dE(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).hgg);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hgE = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.gqb == null) {
            this.gqb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gqb.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.gqb.findViewById(R.id.widget_navi_back_button);
        }
        this.hgF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aGA().a(this.hgF, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.elh = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.elh.a(this.fYJ);
        this.hgJ = findViewById(R.id.pb_editor_tool_comment);
        this.hgK = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.hgK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bPv();
            }
        });
        this.hgL = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.hgI = findViewById(R.id.activity_topic_detail_editor);
        ak(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.hgM.aOr(), layoutParams);
        this.hgO = new com.baidu.tieba.write.c();
        this.hgN = findViewById(R.id.activity_topic_detail_editor_top);
        this.gOm = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.gOm.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gOm.setFadingEdgeLength(0);
        this.gOm.setOverScrollMode(2);
        this.gOm.setOnSrollToBottomListener(this.Az);
        this.gOm.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.gOm, R.color.cp_bg_line_d);
        this.hgH = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.gOm);
        this.hgG = new TopicDetailHeadView(getContext());
        this.hgG.hgC.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void vv(int i) {
                TopicDetailView.this.vu(i);
            }
        });
        if (this.etW == null) {
            this.eli = new PbListView(this.mPageContext.getPageActivity());
            this.eli.getView();
        }
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.eli.setTextColor(am.getColor(R.color.cp_cont_e));
        this.eli.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.eli.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.eli.setText(getResources().getString(R.string.list_has_no_more));
        this.eli.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.hgR == null) {
            this.hgR = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.hgR.j(this.mPageContext.getUniqueId());
        }
    }

    private void ak(Bundle bundle) {
        this.hgM = (a) new b().dV(getContext());
        if (this.hgM != null) {
            this.hgM.a(this.mPageContext);
            this.hgM.b(this.hgV);
            this.hgM.a(this.dyt);
            this.hgM.aOr().gB(true);
            this.hgM.aOr().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.hgM.a((BaseActivity) getContext(), bundle);
            this.hgM.aPq();
            this.hgM.aOr().setId(R.id.topic_editor);
            this.hgP = this.hgM.bPu().getInputView();
            this.hgP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.hgO != null) {
                        if (!TopicDetailView.this.hgO.cUd()) {
                            TopicDetailView.this.mP(false);
                        }
                        TopicDetailView.this.hgO.tH(false);
                    }
                }
            });
        }
    }

    public void mP(boolean z) {
        if (this.hgP != null && this.hgP.getText() != null) {
            int selectionEnd = this.hgP.getSelectionEnd();
            SpannableStringBuilder a = this.hgO.a(this.hgP.getText());
            if (a != null) {
                this.hgO.tH(true);
                this.hgP.setText(a);
                if (z && this.hgO.cUb() >= 0) {
                    this.hgP.requestFocus();
                    this.hgP.setSelection(this.hgO.cUb());
                } else {
                    this.hgP.setSelection(selectionEnd);
                }
                this.hgO.tG(this.hgO.cUb() >= 0);
            }
        }
    }

    public void bPv() {
        if (bc.checkUpIsLogin(getContext())) {
            this.hgM.aPt();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").cy("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(int i) {
        this.hgQ = i;
        this.hgL.setVisibility(0);
        if (i == 1) {
            this.hgL.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.hgL, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.hgL.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.hgL, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.hgL.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.hgL, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.hgL.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.hgL, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bdq();
            } else if (!this.mHasMore) {
                bdq();
            } else {
                bdp();
            }
            if (!StringUtils.isNull(aVar.cQA)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.cQA, 14, StringHelper.STRING_MORE)));
            }
            this.hgG.setData(aVar.hfY);
            this.gOm.addHeaderView(this.hgG);
            this.hgH.setData(aVar.mDataList);
            if (this.mTopicDetailData.hfY.hgd != null) {
                if (this.mTopicDetailData.hfY.hgd.hhy.hhE) {
                    vu(1);
                } else if (this.mTopicDetailData.hfY.hgd.hhz.hhE) {
                    vu(2);
                } else {
                    vu(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.hgL.setVisibility(8);
            }
            this.hgK.setPadding(dimens, 0, 0, 0);
            bPw();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bdq();
        } else {
            bdp();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).hgi = this.mTopicDetailData.bPp();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.gOm.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdr() {
        this.gOm.setNextPage(null);
    }

    public void bdp() {
        this.mHasMore = true;
        this.gOm.setNextPage(this.eli);
        this.eli.startLoadData();
    }

    public void bdq() {
        this.gOm.setNextPage(this.eli);
        this.eli.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gqb) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hgF && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aIa();
            TiebaStatic.log(new an("c13364").cy("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aIa() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.cQA;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.hfX) ? null : Uri.parse(this.mTopicDetailData.hfX);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.dpU = true;
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
            bPw();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.hgJ, R.color.cp_bg_line_h);
            am.setViewTextColor(this.hgK, (int) R.color.cp_cont_d);
            this.hgK.setBackgroundDrawable(am.ay(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            vu(this.hgQ);
            SvgManager.aGA().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.hgF != null) {
                SvgManager.aGA().a(this.hgF, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.elh != null) {
                this.elh.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.etW != null) {
                this.etW.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hgM != null && this.hgM.aOr() != null) {
                this.hgM.aOr().onChangeSkinType(this.mSkinType);
            }
            if (this.eli != null) {
                this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
                this.eli.setTextColor(am.getColor(R.color.cp_cont_e));
                this.eli.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.eli.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.hgG != null) {
                this.hgG.onChangeSkinType();
            }
            if (this.hgH != null) {
                this.hgH.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.gOm, R.color.cp_bg_line_e);
        }
    }

    public void eM(boolean z) {
        if (!bzi()) {
            if (this.etW == null) {
                this.etW = new g(getContext());
                this.etW.onChangeSkinType();
            }
            this.etW.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this);
            this.etW = null;
        }
    }

    public boolean bzi() {
        if (this.etW != null) {
            return this.etW.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.hgE != null) {
                            TopicDetailView.this.hgE.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gOm.setVisibility(8);
            SvgManager.aGA().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bcv() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.gOm.setVisibility(0);
        SvgManager.aGA().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bzj() {
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
        this.gOm.setOnSrollToBottomListener(null);
        if (this.elh != null) {
            this.elh.b(this.fYJ);
        }
        if (this.hgM != null) {
            this.hgM.onDestory();
        }
        if (this.hgS != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hgS);
        }
        hideLoadingView();
        bcv();
    }

    public a getEditor() {
        return this.hgM;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.hgN != null) {
            ViewGroup.LayoutParams layoutParams = this.hgN.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.hgM.aOr().isVisible()) {
                    layoutParams2.addRule(2, this.hgM.aOr().getId());
                } else {
                    layoutParams2.addRule(2, this.hgI.getId());
                }
                this.hgN.setLayoutParams(layoutParams2);
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
            cVar2.hgg = cVar.hgg;
            cVar2.cRe = bjVar;
            cVar2.source = 2;
            cVar2.hgh = this.hgQ;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.hgi = this.mTopicDetailData.bPp();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.hgH.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPw() {
        if (this.mTopicDetailData != null && this.hgG != null) {
            if (this.hgT > this.hgU) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bPx()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bPx() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.hgG.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.hgG.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
