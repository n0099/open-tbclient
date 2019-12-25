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
import com.baidu.tbadk.coreExtra.data.y;
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
/* loaded from: classes6.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e Ac;
    private com.baidu.tbadk.editortools.pb.b duc;
    private NoNetworkView egT;
    private PbListView egU;
    private g eoy;
    private NoNetworkView.a fTz;
    private BdTypeRecyclerView gJa;
    private View gkR;
    private com.baidu.tieba.homepage.topic.topicdetail.a hbb;
    private ImageView hbc;
    private TopicDetailHeadView hbd;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b hbe;
    private View hbf;
    private View hbg;
    private TextView hbh;
    private TextView hbi;
    private a hbj;
    private View hbk;
    private com.baidu.tieba.write.c hbl;
    private EditText hbm;
    private int hbn;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a hbo;
    a.RunnableC0508a hbp;
    private int hbq;
    private int hbr;
    private NewWriteModel.d hbs;
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
        this.hbg = null;
        this.hbh = null;
        this.hbi = null;
        this.mHasMore = true;
        this.hbq = 0;
        this.hbr = 44;
        this.fTz = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.hbb != null) {
                    TopicDetailView.this.hbb.loadData();
                }
            }
        };
        this.duc = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean aLZ() {
                if (TopicDetailView.this.hbl.cRJ()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.hbl.cRL());
                    TopicDetailView.this.mC(true);
                    return true;
                }
                return false;
            }
        };
        this.hbs = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.hbj != null && TopicDetailView.this.hbj.aLC() != null) {
                    TopicDetailView.this.hbj.aLC().hide();
                }
                if (z) {
                    TopicDetailView.this.hbl.Kn(null);
                    TopicDetailView.this.hbl.aV(null);
                    TopicDetailView.this.hbl.tq(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.hbp = TopicDetailView.this.hbo.A(j, j2);
                            com.baidu.adp.lib.f.e.gy().postDelayed(TopicDetailView.this.hbp, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.hbl.aV(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.hbl.Kn(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.hbl.cRH())) {
                        TopicDetailView.this.mC(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.hbj != null) {
                    TopicDetailView.this.hbj.aMB();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.gJa, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.hbq += i2;
                TopicDetailView.this.bMM();
            }
        };
        this.Ac = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.baH();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dz(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).haC);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hbb = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.gkR == null) {
            this.gkR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gkR.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.gkR.findViewById(R.id.widget_navi_back_button);
        }
        this.hbc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aDW().a(this.hbc, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.egT = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.egT.a(this.fTz);
        this.hbg = findViewById(R.id.pb_editor_tool_comment);
        this.hbh = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.hbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bML();
            }
        });
        this.hbi = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.hbf = findViewById(R.id.activity_topic_detail_editor);
        ak(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.hbj.aLC(), layoutParams);
        this.hbl = new com.baidu.tieba.write.c();
        this.hbk = findViewById(R.id.activity_topic_detail_editor_top);
        this.gJa = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.gJa.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gJa.setFadingEdgeLength(0);
        this.gJa.setOverScrollMode(2);
        this.gJa.setOnSrollToBottomListener(this.Ac);
        this.gJa.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.gJa, R.color.cp_bg_line_d);
        this.hbe = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.gJa);
        this.hbd = new TopicDetailHeadView(getContext());
        this.hbd.haZ.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void vk(int i) {
                TopicDetailView.this.vj(i);
            }
        });
        if (this.eoy == null) {
            this.egU = new PbListView(this.mPageContext.getPageActivity());
            this.egU.getView();
        }
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.egU.setTextColor(am.getColor(R.color.cp_cont_e));
        this.egU.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.egU.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.egU.setText(getResources().getString(R.string.list_has_no_more));
        this.egU.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.hbo == null) {
            this.hbo = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.hbo.j(this.mPageContext.getUniqueId());
        }
    }

    private void ak(Bundle bundle) {
        this.hbj = (a) new b().dR(getContext());
        if (this.hbj != null) {
            this.hbj.a(this.mPageContext);
            this.hbj.b(this.hbs);
            this.hbj.a(this.duc);
            this.hbj.aLC().gp(true);
            this.hbj.aLC().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.hbj.a((BaseActivity) getContext(), bundle);
            this.hbj.aMB();
            this.hbj.aLC().setId(R.id.topic_editor);
            this.hbm = this.hbj.bMK().getInputView();
            this.hbm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.hbl != null) {
                        if (!TopicDetailView.this.hbl.cRK()) {
                            TopicDetailView.this.mC(false);
                        }
                        TopicDetailView.this.hbl.tr(false);
                    }
                }
            });
        }
    }

    public void mC(boolean z) {
        if (this.hbm != null && this.hbm.getText() != null) {
            int selectionEnd = this.hbm.getSelectionEnd();
            SpannableStringBuilder a = this.hbl.a(this.hbm.getText());
            if (a != null) {
                this.hbl.tr(true);
                this.hbm.setText(a);
                if (z && this.hbl.cRI() >= 0) {
                    this.hbm.requestFocus();
                    this.hbm.setSelection(this.hbl.cRI());
                } else {
                    this.hbm.setSelection(selectionEnd);
                }
                this.hbl.tq(this.hbl.cRI() >= 0);
            }
        }
    }

    public void bML() {
        if (bc.checkUpIsLogin(getContext())) {
            this.hbj.aME();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").cp("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj(int i) {
        this.hbn = i;
        this.hbi.setVisibility(0);
        if (i == 1) {
            this.hbi.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.hbi, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.hbi.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.hbi, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.hbi.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.hbi, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.hbi.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.hbi, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                baG();
            } else if (!this.mHasMore) {
                baG();
            } else {
                baF();
            }
            if (!StringUtils.isNull(aVar.cMn)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.cMn, 14, StringHelper.STRING_MORE)));
            }
            this.hbd.setData(aVar.hau);
            this.gJa.addHeaderView(this.hbd);
            this.hbe.setData(aVar.mDataList);
            if (this.mTopicDetailData.hau.haz != null) {
                if (this.mTopicDetailData.hau.haz.hbV.hcb) {
                    vj(1);
                } else if (this.mTopicDetailData.hau.haz.hbW.hcb) {
                    vj(2);
                } else {
                    vj(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.hbi.setVisibility(8);
            }
            this.hbh.setPadding(dimens, 0, 0, 0);
            bMM();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            baG();
        } else {
            baF();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).haE = this.mTopicDetailData.bMF();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.gJa.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baH() {
        this.gJa.setNextPage(null);
    }

    public void baF() {
        this.mHasMore = true;
        this.gJa.setNextPage(this.egU);
        this.egU.startLoadData();
    }

    public void baG() {
        this.gJa.setNextPage(this.egU);
        this.egU.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gkR) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hbc && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aFs();
            TiebaStatic.log(new an("c13364").cp("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aFs() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.cMn;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.hat) ? null : Uri.parse(this.mTopicDetailData.hat);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.dlw = true;
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
            bMM();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.hbg, R.color.cp_bg_line_h);
            am.setViewTextColor(this.hbh, (int) R.color.cp_cont_d);
            this.hbh.setBackgroundDrawable(am.au(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            vj(this.hbn);
            SvgManager.aDW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.hbc != null) {
                SvgManager.aDW().a(this.hbc, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.egT != null) {
                this.egT.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eoy != null) {
                this.eoy.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hbj != null && this.hbj.aLC() != null) {
                this.hbj.aLC().onChangeSkinType(this.mSkinType);
            }
            if (this.egU != null) {
                this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
                this.egU.setTextColor(am.getColor(R.color.cp_cont_e));
                this.egU.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.egU.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.hbd != null) {
                this.hbd.onChangeSkinType();
            }
            if (this.hbe != null) {
                this.hbe.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.gJa, R.color.cp_bg_line_e);
        }
    }

    public void eA(boolean z) {
        if (!bwE()) {
            if (this.eoy == null) {
                this.eoy = new g(getContext());
                this.eoy.onChangeSkinType();
            }
            this.eoy.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this);
            this.eoy = null;
        }
    }

    public boolean bwE() {
        if (this.eoy != null) {
            return this.eoy.isViewAttached();
        }
        return false;
    }

    public void ky(boolean z) {
        if (!bwF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.hbb != null) {
                            TopicDetailView.this.hbb.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gJa.setVisibility(8);
            SvgManager.aDW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void aZK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.gJa.setVisibility(0);
        SvgManager.aDW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bwF() {
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
        this.gJa.setOnSrollToBottomListener(null);
        if (this.egT != null) {
            this.egT.b(this.fTz);
        }
        if (this.hbj != null) {
            this.hbj.onDestory();
        }
        if (this.hbp != null) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hbp);
        }
        hideLoadingView();
        aZK();
    }

    public a getEditor() {
        return this.hbj;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.hbk != null) {
            ViewGroup.LayoutParams layoutParams = this.hbk.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.hbj.aLC().isVisible()) {
                    layoutParams2.addRule(2, this.hbj.aLC().getId());
                } else {
                    layoutParams2.addRule(2, this.hbf.getId());
                }
                this.hbk.setLayoutParams(layoutParams2);
            }
        }
    }

    public void ax(bj bjVar) {
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
            cVar2.haC = cVar.haC;
            cVar2.cMR = bjVar;
            cVar2.source = 2;
            cVar2.haD = this.hbn;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.haE = this.mTopicDetailData.bMF();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.hbe.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMM() {
        if (this.mTopicDetailData != null && this.hbd != null) {
            if (this.hbq > this.hbr) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bMN()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bMN() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.hbd.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.hbd.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
