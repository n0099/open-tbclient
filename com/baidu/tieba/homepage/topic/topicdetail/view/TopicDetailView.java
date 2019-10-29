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
    private com.baidu.tbadk.editortools.pb.b cGZ;
    private g dEq;
    private NoNetworkView dwI;
    private PbListView dwJ;
    private NoNetworkView.a eRC;
    private BdTypeRecyclerView fVr;
    private View fxl;
    private View goA;
    private com.baidu.tieba.write.b goB;
    private EditText goC;
    private int goD;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a goE;
    a.RunnableC0427a goF;
    private int goG;
    private int goH;
    private NewWriteModel.d goI;
    private com.baidu.tieba.homepage.topic.topicdetail.a gor;
    private ImageView gos;
    private TopicDetailHeadView got;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b gou;
    private View gov;
    private View gow;
    private TextView gox;
    private TextView goy;
    private a goz;
    private ImageView mBackImageView;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private int mSkinType;
    private com.baidu.tieba.homepage.topic.topicdetail.b.a mTopicDetailData;
    private BdListView.e ye;

    public TopicDetailView(TbPageContext<?> tbPageContext, com.baidu.tieba.homepage.topic.topicdetail.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gow = null;
        this.gox = null;
        this.goy = null;
        this.mHasMore = true;
        this.goG = 0;
        this.goH = 44;
        this.eRC = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.gor != null) {
                    TopicDetailView.this.gor.loadData();
                }
            }
        };
        this.cGZ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean auw() {
                if (TopicDetailView.this.goB.cxA()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.goB.cxC());
                    TopicDetailView.this.lp(true);
                    return true;
                }
                return false;
            }
        };
        this.goI = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.goz != null && TopicDetailView.this.goz.atZ() != null) {
                    TopicDetailView.this.goz.atZ().hide();
                }
                if (z) {
                    TopicDetailView.this.goB.Fv(null);
                    TopicDetailView.this.goB.aM(null);
                    TopicDetailView.this.goB.rK(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.g.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.g.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.goF = TopicDetailView.this.goE.v(j, j2);
                            com.baidu.adp.lib.g.e.fZ().postDelayed(TopicDetailView.this.goF, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.goB.aM(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.goB.Fv(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.goB.cxy())) {
                        TopicDetailView.this.lp(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.goz != null) {
                    TopicDetailView.this.goz.auV();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fVr, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.goG += i2;
                TopicDetailView.this.bvA();
            }
        };
        this.ye = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.aKk();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).cU(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).gnS);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gor = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.fxl == null) {
            this.fxl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fxl.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.fxl.findViewById(R.id.widget_navi_back_button);
        }
        this.gos = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.amN().a(this.gos, R.drawable.icon_pure_topbar_share_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dwI = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.dwI.a(this.eRC);
        this.gow = findViewById(R.id.pb_editor_tool_comment);
        this.gox = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.gox.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bvz();
            }
        });
        this.goy = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.gov = findViewById(R.id.activity_topic_detail_editor);
        R(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.goz.atZ(), layoutParams);
        this.goB = new com.baidu.tieba.write.b();
        this.goA = findViewById(R.id.activity_topic_detail_editor_top);
        this.fVr = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.fVr.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fVr.setFadingEdgeLength(0);
        this.fVr.setOverScrollMode(2);
        this.fVr.setOnSrollToBottomListener(this.ye);
        this.fVr.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.fVr, R.color.cp_bg_line_d);
        this.gou = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fVr);
        this.got = new TopicDetailHeadView(getContext());
        this.got.gop.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void tj(int i) {
                TopicDetailView.this.ti(i);
            }
        });
        if (this.dEq == null) {
            this.dwJ = new PbListView(this.mPageContext.getPageActivity());
            this.dwJ.getView();
        }
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_e));
        this.dwJ.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.dwJ.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.dwJ.setText(getResources().getString(R.string.list_has_no_more));
        this.dwJ.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.goE == null) {
            this.goE = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.goE.j(this.mPageContext.getUniqueId());
        }
    }

    private void R(Bundle bundle) {
        this.goz = (a) new b().cw(getContext());
        if (this.goz != null) {
            this.goz.a(this.mPageContext);
            this.goz.b(this.goI);
            this.goz.a(this.cGZ);
            this.goz.atZ().fe(true);
            this.goz.atZ().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.goz.a((BaseActivity) getContext(), bundle);
            this.goz.auV();
            this.goz.atZ().setId(R.id.topic_editor);
            this.goC = this.goz.bvy().getInputView();
            this.goC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.goB != null) {
                        if (!TopicDetailView.this.goB.cxB()) {
                            TopicDetailView.this.lp(false);
                        }
                        TopicDetailView.this.goB.rL(false);
                    }
                }
            });
        }
    }

    public void lp(boolean z) {
        if (this.goC != null && this.goC.getText() != null) {
            int selectionEnd = this.goC.getSelectionEnd();
            SpannableStringBuilder a = this.goB.a(this.goC.getText());
            if (a != null) {
                this.goB.rL(true);
                this.goC.setText(a);
                if (z && this.goB.cxz() >= 0) {
                    this.goC.requestFocus();
                    this.goC.setSelection(this.goB.cxz());
                } else {
                    this.goC.setSelection(selectionEnd);
                }
                this.goB.rK(this.goB.cxz() >= 0);
            }
        }
    }

    public void bvz() {
        if (bc.checkUpIsLogin(getContext())) {
            this.goz.auY();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").bS("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(int i) {
        this.goD = i;
        this.goy.setVisibility(0);
        if (i == 1) {
            this.goy.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.goy, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.goy.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.goy, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.goy.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.goy, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.goy.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.goy, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aKj();
            } else if (!this.mHasMore) {
                aKj();
            } else {
                aKi();
            }
            if (!StringUtils.isNull(aVar.caN)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.caN, 14, StringHelper.STRING_MORE)));
            }
            this.got.setData(aVar.gnK);
            this.fVr.addHeaderView(this.got);
            this.gou.setData(aVar.mDataList);
            if (this.mTopicDetailData.gnK.gnP != null) {
                if (this.mTopicDetailData.gnK.gnP.gpl.gpr) {
                    ti(1);
                } else if (this.mTopicDetailData.gnK.gnP.gpm.gpr) {
                    ti(2);
                } else {
                    ti(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.goy.setVisibility(8);
            }
            this.gox.setPadding(dimens, 0, 0, 0);
            bvA();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aKj();
        } else {
            aKi();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).gnU = this.mTopicDetailData.bvt();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fVr.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKk() {
        this.fVr.setNextPage(null);
    }

    public void aKi() {
        this.mHasMore = true;
        this.fVr.setNextPage(this.dwJ);
        this.dwJ.startLoadData();
    }

    public void aKj() {
        this.fVr.setNextPage(this.dwJ);
        this.dwJ.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fxl) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gos && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aoa();
            TiebaStatic.log(new an("c13364").bS("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aoa() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.caN;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.gnJ) ? null : Uri.parse(this.mTopicDetailData.gnJ);
            final com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = str2;
            eVar.linkUrl = str3;
            eVar.cyA = true;
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
            bvA();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.gow, R.color.cp_bg_line_h);
            am.setViewTextColor(this.gox, (int) R.color.cp_cont_d);
            this.gox.setBackgroundDrawable(am.ab(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            ti(this.goD);
            SvgManager.amN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.gos != null) {
                SvgManager.amN().a(this.gos, R.drawable.icon_pure_topbar_share_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.dwI != null) {
                this.dwI.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.dEq != null) {
                this.dEq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.goz != null && this.goz.atZ() != null) {
                this.goz.atZ().onChangeSkinType(this.mSkinType);
            }
            if (this.dwJ != null) {
                this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
                this.dwJ.setTextColor(am.getColor(R.color.cp_cont_e));
                this.dwJ.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.dwJ.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.got != null) {
                this.got.onChangeSkinType();
            }
            if (this.gou != null) {
                this.gou.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.fVr, R.color.cp_bg_line_e);
        }
    }

    public void dp(boolean z) {
        if (!bfl()) {
            if (this.dEq == null) {
                this.dEq = new g(getContext());
                this.dEq.onChangeSkinType();
            }
            this.dEq.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dEq != null) {
            this.dEq.dettachView(this);
            this.dEq = null;
        }
    }

    public boolean bfl() {
        if (this.dEq != null) {
            return this.dEq.isViewAttached();
        }
        return false;
    }

    public void jm(boolean z) {
        if (!bfm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.gor != null) {
                            TopicDetailView.this.gor.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.fVr.setVisibility(8);
            SvgManager.amN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void aJo() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fVr.setVisibility(0);
        SvgManager.amN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bfm() {
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
        this.fVr.setOnSrollToBottomListener(null);
        if (this.dwI != null) {
            this.dwI.b(this.eRC);
        }
        if (this.goz != null) {
            this.goz.onDestory();
        }
        if (this.goF != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.goF);
        }
        hideLoadingView();
        aJo();
    }

    public a getEditor() {
        return this.goz;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.goA != null) {
            ViewGroup.LayoutParams layoutParams = this.goA.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.goz.atZ().isVisible()) {
                    layoutParams2.addRule(2, this.goz.atZ().getId());
                } else {
                    layoutParams2.addRule(2, this.gov.getId());
                }
                this.goA.setLayoutParams(layoutParams2);
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
            cVar2.gnS = cVar.gnS;
            cVar2.cbq = bhVar;
            cVar2.source = 2;
            cVar2.gnT = this.goD;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.gnU = this.mTopicDetailData.bvt();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.gou.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvA() {
        if (this.mTopicDetailData != null && this.got != null) {
            if (this.goG > this.goH) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bvB()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bvB() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.got.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.got.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
