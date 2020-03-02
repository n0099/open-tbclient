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
    private com.baidu.tbadk.editortools.pb.b dyu;
    private NoNetworkView eli;
    private PbListView elj;
    private g etX;
    private NoNetworkView.a fYL;
    private BdTypeRecyclerView gOo;
    private View gqd;
    private com.baidu.tieba.homepage.topic.topicdetail.a hgG;
    private ImageView hgH;
    private TopicDetailHeadView hgI;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b hgJ;
    private View hgK;
    private View hgL;
    private TextView hgM;
    private TextView hgN;
    private a hgO;
    private View hgP;
    private com.baidu.tieba.write.c hgQ;
    private EditText hgR;
    private int hgS;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a hgT;
    a.RunnableC0520a hgU;
    private int hgV;
    private int hgW;
    private NewWriteModel.d hgX;
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
        this.hgL = null;
        this.hgM = null;
        this.hgN = null;
        this.mHasMore = true;
        this.hgV = 0;
        this.hgW = 44;
        this.fYL = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.hgG != null) {
                    TopicDetailView.this.hgG.loadData();
                }
            }
        };
        this.dyu = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean aOQ() {
                if (TopicDetailView.this.hgQ.cUe()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.hgQ.cUg());
                    TopicDetailView.this.mP(true);
                    return true;
                }
                return false;
            }
        };
        this.hgX = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.hgO != null && TopicDetailView.this.hgO.aOt() != null) {
                    TopicDetailView.this.hgO.aOt().hide();
                }
                if (z) {
                    TopicDetailView.this.hgQ.KK(null);
                    TopicDetailView.this.hgQ.aU(null);
                    TopicDetailView.this.hgQ.tG(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.hgU = TopicDetailView.this.hgT.A(j, j2);
                            com.baidu.adp.lib.f.e.gx().postDelayed(TopicDetailView.this.hgU, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.hgQ.aU(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.hgQ.KK(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.hgQ.cUc())) {
                        TopicDetailView.this.mP(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.hgO != null) {
                    TopicDetailView.this.hgO.aPs();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.gOo, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.hgV += i2;
                TopicDetailView.this.bPy();
            }
        };
        this.Az = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bdt();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dE(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).hgi);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hgG = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.gqd == null) {
            this.gqd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gqd.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.gqd.findViewById(R.id.widget_navi_back_button);
        }
        this.hgH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aGC().a(this.hgH, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.eli = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.eli.a(this.fYL);
        this.hgL = findViewById(R.id.pb_editor_tool_comment);
        this.hgM = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.hgM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bPx();
            }
        });
        this.hgN = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.hgK = findViewById(R.id.activity_topic_detail_editor);
        ak(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.hgO.aOt(), layoutParams);
        this.hgQ = new com.baidu.tieba.write.c();
        this.hgP = findViewById(R.id.activity_topic_detail_editor_top);
        this.gOo = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.gOo.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gOo.setFadingEdgeLength(0);
        this.gOo.setOverScrollMode(2);
        this.gOo.setOnSrollToBottomListener(this.Az);
        this.gOo.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.gOo, R.color.cp_bg_line_d);
        this.hgJ = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.gOo);
        this.hgI = new TopicDetailHeadView(getContext());
        this.hgI.hgE.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void vv(int i) {
                TopicDetailView.this.vu(i);
            }
        });
        if (this.etX == null) {
            this.elj = new PbListView(this.mPageContext.getPageActivity());
            this.elj.getView();
        }
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elj.setTextColor(am.getColor(R.color.cp_cont_e));
        this.elj.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.elj.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.elj.setText(getResources().getString(R.string.list_has_no_more));
        this.elj.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.hgT == null) {
            this.hgT = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.hgT.j(this.mPageContext.getUniqueId());
        }
    }

    private void ak(Bundle bundle) {
        this.hgO = (a) new b().dV(getContext());
        if (this.hgO != null) {
            this.hgO.a(this.mPageContext);
            this.hgO.b(this.hgX);
            this.hgO.a(this.dyu);
            this.hgO.aOt().gB(true);
            this.hgO.aOt().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.hgO.a((BaseActivity) getContext(), bundle);
            this.hgO.aPs();
            this.hgO.aOt().setId(R.id.topic_editor);
            this.hgR = this.hgO.bPw().getInputView();
            this.hgR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.hgQ != null) {
                        if (!TopicDetailView.this.hgQ.cUf()) {
                            TopicDetailView.this.mP(false);
                        }
                        TopicDetailView.this.hgQ.tH(false);
                    }
                }
            });
        }
    }

    public void mP(boolean z) {
        if (this.hgR != null && this.hgR.getText() != null) {
            int selectionEnd = this.hgR.getSelectionEnd();
            SpannableStringBuilder a = this.hgQ.a(this.hgR.getText());
            if (a != null) {
                this.hgQ.tH(true);
                this.hgR.setText(a);
                if (z && this.hgQ.cUd() >= 0) {
                    this.hgR.requestFocus();
                    this.hgR.setSelection(this.hgQ.cUd());
                } else {
                    this.hgR.setSelection(selectionEnd);
                }
                this.hgQ.tG(this.hgQ.cUd() >= 0);
            }
        }
    }

    public void bPx() {
        if (bc.checkUpIsLogin(getContext())) {
            this.hgO.aPv();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").cy("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(int i) {
        this.hgS = i;
        this.hgN.setVisibility(0);
        if (i == 1) {
            this.hgN.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.hgN, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.hgN.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.hgN, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.hgN.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.hgN, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.hgN.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.hgN, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bds();
            } else if (!this.mHasMore) {
                bds();
            } else {
                bdr();
            }
            if (!StringUtils.isNull(aVar.cQB)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.cQB, 14, StringHelper.STRING_MORE)));
            }
            this.hgI.setData(aVar.hga);
            this.gOo.addHeaderView(this.hgI);
            this.hgJ.setData(aVar.mDataList);
            if (this.mTopicDetailData.hga.hgf != null) {
                if (this.mTopicDetailData.hga.hgf.hhA.hhG) {
                    vu(1);
                } else if (this.mTopicDetailData.hga.hgf.hhB.hhG) {
                    vu(2);
                } else {
                    vu(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.hgN.setVisibility(8);
            }
            this.hgM.setPadding(dimens, 0, 0, 0);
            bPy();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bds();
        } else {
            bdr();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).hgk = this.mTopicDetailData.bPr();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.gOo.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdt() {
        this.gOo.setNextPage(null);
    }

    public void bdr() {
        this.mHasMore = true;
        this.gOo.setNextPage(this.elj);
        this.elj.startLoadData();
    }

    public void bds() {
        this.gOo.setNextPage(this.elj);
        this.elj.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gqd) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hgH && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aIc();
            TiebaStatic.log(new an("c13364").cy("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aIc() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.cQB;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.hfZ) ? null : Uri.parse(this.mTopicDetailData.hfZ);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.dpV = true;
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
            bPy();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.hgL, R.color.cp_bg_line_h);
            am.setViewTextColor(this.hgM, (int) R.color.cp_cont_d);
            this.hgM.setBackgroundDrawable(am.ay(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            vu(this.hgS);
            SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.hgH != null) {
                SvgManager.aGC().a(this.hgH, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.eli != null) {
                this.eli.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.etX != null) {
                this.etX.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hgO != null && this.hgO.aOt() != null) {
                this.hgO.aOt().onChangeSkinType(this.mSkinType);
            }
            if (this.elj != null) {
                this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
                this.elj.setTextColor(am.getColor(R.color.cp_cont_e));
                this.elj.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.elj.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.hgI != null) {
                this.hgI.onChangeSkinType();
            }
            if (this.hgJ != null) {
                this.hgJ.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.gOo, R.color.cp_bg_line_e);
        }
    }

    public void eM(boolean z) {
        if (!bzk()) {
            if (this.etX == null) {
                this.etX = new g(getContext());
                this.etX.onChangeSkinType();
            }
            this.etX.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this);
            this.etX = null;
        }
    }

    public boolean bzk() {
        if (this.etX != null) {
            return this.etX.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzl()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.hgG != null) {
                            TopicDetailView.this.hgG.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gOo.setVisibility(8);
            SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bcx() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.gOo.setVisibility(0);
        SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bzl() {
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
        this.gOo.setOnSrollToBottomListener(null);
        if (this.eli != null) {
            this.eli.b(this.fYL);
        }
        if (this.hgO != null) {
            this.hgO.onDestory();
        }
        if (this.hgU != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hgU);
        }
        hideLoadingView();
        bcx();
    }

    public a getEditor() {
        return this.hgO;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.hgP != null) {
            ViewGroup.LayoutParams layoutParams = this.hgP.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.hgO.aOt().isVisible()) {
                    layoutParams2.addRule(2, this.hgO.aOt().getId());
                } else {
                    layoutParams2.addRule(2, this.hgK.getId());
                }
                this.hgP.setLayoutParams(layoutParams2);
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
            cVar2.hgi = cVar.hgi;
            cVar2.cRf = bjVar;
            cVar2.source = 2;
            cVar2.hgj = this.hgS;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.hgk = this.mTopicDetailData.bPr();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.hgJ.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPy() {
        if (this.mTopicDetailData != null && this.hgI != null) {
            if (this.hgV > this.hgW) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bPz()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bPz() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.hgI.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.hgI.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
