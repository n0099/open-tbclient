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
    private BdListView.e TT;
    private com.baidu.tbadk.editortools.pb.b dYG;
    private NoNetworkView ePq;
    private PbListView ePr;
    private g eYg;
    private NoNetworkView.a gGr;
    private com.baidu.tieba.homepage.topic.topicdetail.a hSi;
    private ImageView hSj;
    private TopicDetailHeadView hSk;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b hSl;
    private View hSm;
    private View hSn;
    private TextView hSo;
    private TextView hSp;
    private a hSq;
    private View hSr;
    private com.baidu.tieba.write.c hSs;
    private EditText hSt;
    private int hSu;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a hSv;
    a.RunnableC0579a hSw;
    private int hSx;
    private int hSy;
    private NewWriteModel.d hSz;
    private View har;
    private BdTypeRecyclerView hzM;
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
        this.hSn = null;
        this.hSo = null;
        this.hSp = null;
        this.mHasMore = true;
        this.hSx = 0;
        this.hSy = 44;
        this.gGr = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.hSi != null) {
                    TopicDetailView.this.hSi.loadData();
                }
            }
        };
        this.dYG = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean aXk() {
                if (TopicDetailView.this.hSs.deR()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.hSs.deT());
                    TopicDetailView.this.nZ(true);
                    return true;
                }
                return false;
            }
        };
        this.hSz = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.hSq != null && TopicDetailView.this.hSq.aWN() != null) {
                    TopicDetailView.this.hSq.aWN().hide();
                }
                if (z) {
                    TopicDetailView.this.hSs.Ms(null);
                    TopicDetailView.this.hSs.aW(null);
                    TopicDetailView.this.hSs.uN(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.hSw = TopicDetailView.this.hSv.B(j, j2);
                            com.baidu.adp.lib.f.e.lb().postDelayed(TopicDetailView.this.hSw, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.hSs.aW(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.hSs.Ms(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.hSs.deP())) {
                        TopicDetailView.this.nZ(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.hSq != null) {
                    TopicDetailView.this.hSq.aXM();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.hzM, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.hSx += i2;
                TopicDetailView.this.cap();
            }
        };
        this.TT = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bmo();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).eo(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).hRK);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hSi = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.har == null) {
            this.har = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.har.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.har.findViewById(R.id.widget_navi_back_button);
        }
        this.hSj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aOR().a(this.hSj, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.ePq = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.ePq.a(this.gGr);
        this.hSn = findViewById(R.id.pb_editor_tool_comment);
        this.hSo = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.hSo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cao();
            }
        });
        this.hSp = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.hSm = findViewById(R.id.activity_topic_detail_editor);
        ak(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.hSq.aWN(), layoutParams);
        this.hSs = new com.baidu.tieba.write.c();
        this.hSr = findViewById(R.id.activity_topic_detail_editor_top);
        this.hzM = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.hzM.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hzM.setFadingEdgeLength(0);
        this.hzM.setOverScrollMode(2);
        this.hzM.setOnSrollToBottomListener(this.TT);
        this.hzM.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.hzM, R.color.cp_bg_line_d);
        this.hSl = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.hzM);
        this.hSk = new TopicDetailHeadView(getContext());
        this.hSk.hSg.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void wb(int i) {
                TopicDetailView.this.wa(i);
            }
        });
        if (this.eYg == null) {
            this.ePr = new PbListView(this.mPageContext.getPageActivity());
            this.ePr.getView();
        }
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_e));
        this.ePr.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.ePr.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.ePr.setText(getResources().getString(R.string.list_has_no_more));
        this.ePr.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.hSv == null) {
            this.hSv = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.hSv.j(this.mPageContext.getUniqueId());
        }
    }

    private void ak(Bundle bundle) {
        this.hSq = (a) new b().dw(getContext());
        if (this.hSq != null) {
            this.hSq.a(this.mPageContext);
            this.hSq.b(this.hSz);
            this.hSq.a(this.dYG);
            this.hSq.aWN().hA(true);
            this.hSq.aWN().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.hSq.a((BaseActivity) getContext(), bundle);
            this.hSq.aXM();
            this.hSq.aWN().setId(R.id.topic_editor);
            this.hSt = this.hSq.can().getInputView();
            this.hSt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.hSs != null) {
                        if (!TopicDetailView.this.hSs.deS()) {
                            TopicDetailView.this.nZ(false);
                        }
                        TopicDetailView.this.hSs.uO(false);
                    }
                }
            });
        }
    }

    public void nZ(boolean z) {
        if (this.hSt != null && this.hSt.getText() != null) {
            int selectionEnd = this.hSt.getSelectionEnd();
            SpannableStringBuilder a = this.hSs.a(this.hSt.getText());
            if (a != null) {
                this.hSs.uO(true);
                this.hSt.setText(a);
                if (z && this.hSs.deQ() >= 0) {
                    this.hSt.requestFocus();
                    this.hSt.setSelection(this.hSs.deQ());
                } else {
                    this.hSt.setSelection(selectionEnd);
                }
                this.hSs.uN(this.hSs.deQ() >= 0);
            }
        }
    }

    public void cao() {
        if (bc.checkUpIsLogin(getContext())) {
            this.hSq.aXP();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").cI("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(int i) {
        this.hSu = i;
        this.hSp.setVisibility(0);
        if (i == 1) {
            this.hSp.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.hSp, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.hSp.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.hSp, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.hSp.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.hSp, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.hSp.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.hSp, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bmn();
            } else if (!this.mHasMore) {
                bmn();
            } else {
                bmm();
            }
            if (!StringUtils.isNull(aVar.dpZ)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.dpZ, 14, StringHelper.STRING_MORE)));
            }
            this.hSk.setData(aVar.hRC);
            this.hzM.addHeaderView(this.hSk);
            this.hSl.setData(aVar.mDataList);
            if (this.mTopicDetailData.hRC.hRH != null) {
                if (this.mTopicDetailData.hRC.hRH.hTc.hTi) {
                    wa(1);
                } else if (this.mTopicDetailData.hRC.hRH.hTd.hTi) {
                    wa(2);
                } else {
                    wa(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.hSp.setVisibility(8);
            }
            this.hSo.setPadding(dimens, 0, 0, 0);
            cap();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bmn();
        } else {
            bmm();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).hRM = this.mTopicDetailData.cai();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.hzM.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmo() {
        this.hzM.setNextPage(null);
    }

    public void bmm() {
        this.mHasMore = true;
        this.hzM.setNextPage(this.ePr);
        this.ePr.startLoadData();
    }

    public void bmn() {
        this.hzM.setNextPage(this.ePr);
        this.ePr.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.har) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hSj && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aQA();
            TiebaStatic.log(new an("c13364").cI("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aQA() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.dpZ;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.hRB) ? null : Uri.parse(this.mTopicDetailData.hRB);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.dQt = true;
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
            cap();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.hSn, R.color.cp_bg_line_h);
            am.setViewTextColor(this.hSo, (int) R.color.cp_cont_d);
            this.hSo.setBackgroundDrawable(am.aB(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            wa(this.hSu);
            SvgManager.aOR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.hSj != null) {
                SvgManager.aOR().a(this.hSj, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.ePq != null) {
                this.ePq.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eYg != null) {
                this.eYg.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hSq != null && this.hSq.aWN() != null) {
                this.hSq.aWN().onChangeSkinType(this.mSkinType);
            }
            if (this.ePr != null) {
                this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
                this.ePr.setTextColor(am.getColor(R.color.cp_cont_e));
                this.ePr.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.ePr.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.hSk != null) {
                this.hSk.onChangeSkinType();
            }
            if (this.hSl != null) {
                this.hSl.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.hzM, R.color.cp_bg_line_e);
        }
    }

    public void fK(boolean z) {
        if (!bJr()) {
            if (this.eYg == null) {
                this.eYg = new g(getContext());
                this.eYg.onChangeSkinType();
            }
            this.eYg.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this);
            this.eYg = null;
        }
    }

    public boolean bJr() {
        if (this.eYg != null) {
            return this.eYg.isViewAttached();
        }
        return false;
    }

    public void lV(boolean z) {
        if (!bJs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.hSi != null) {
                            TopicDetailView.this.hSi.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hzM.setVisibility(8);
            SvgManager.aOR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void blr() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.hzM.setVisibility(0);
        SvgManager.aOR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bJs() {
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
        this.hzM.setOnSrollToBottomListener(null);
        if (this.ePq != null) {
            this.ePq.b(this.gGr);
        }
        if (this.hSq != null) {
            this.hSq.onDestory();
        }
        if (this.hSw != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hSw);
        }
        hideLoadingView();
        blr();
    }

    public a getEditor() {
        return this.hSq;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.hSr != null) {
            ViewGroup.LayoutParams layoutParams = this.hSr.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.hSq.aWN().isVisible()) {
                    layoutParams2.addRule(2, this.hSq.aWN().getId());
                } else {
                    layoutParams2.addRule(2, this.hSm.getId());
                }
                this.hSr.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aE(bj bjVar) {
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
            cVar2.hRK = cVar.hRK;
            cVar2.dqE = bjVar;
            cVar2.source = 2;
            cVar2.hRL = this.hSu;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.hRM = this.mTopicDetailData.cai();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.hSl.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cap() {
        if (this.mTopicDetailData != null && this.hSk != null) {
            if (this.hSx > this.hSy) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(caq()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap caq() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.hSk.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.hSk.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
