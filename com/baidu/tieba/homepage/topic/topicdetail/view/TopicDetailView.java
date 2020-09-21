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
import com.baidu.tbadk.coreExtra.data.ah;
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
/* loaded from: classes21.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e Vz;
    private com.baidu.tbadk.editortools.pb.b ePs;
    private NoNetworkView.a fFF;
    private NoNetworkView fHl;
    private PbListView fHm;
    private g fQf;
    private BdTypeRecyclerView iEj;
    private View icu;
    private com.baidu.tieba.homepage.topic.topicdetail.a jcA;
    private ImageView jcB;
    private TopicDetailHeadView jcC;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b jcD;
    private View jcE;
    private View jcF;
    private TextView jcG;
    private TextView jcH;
    private a jcI;
    private View jcJ;
    private com.baidu.tieba.write.c jcK;
    private EditText jcL;
    private int jcM;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a jcN;
    a.RunnableC0698a jcO;
    private int jcP;
    private int jcQ;
    private NewWriteModel.d jcR;
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
        this.jcF = null;
        this.jcG = null;
        this.jcH = null;
        this.mHasMore = true;
        this.jcP = 0;
        this.jcQ = 44;
        this.fFF = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.jcA != null) {
                    TopicDetailView.this.jcA.loadData();
                }
            }
        };
        this.ePs = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bsZ() {
                if (TopicDetailView.this.jcK.dJz()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.jcK.dJB());
                    TopicDetailView.this.qa(true);
                    return true;
                }
                return false;
            }
        };
        this.jcR = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.jcI != null && TopicDetailView.this.jcI.bsv() != null) {
                    TopicDetailView.this.jcI.bsv().hide();
                }
                if (z) {
                    TopicDetailView.this.jcK.SW(null);
                    TopicDetailView.this.jcK.bh(null);
                    TopicDetailView.this.jcK.xi(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.jcO = TopicDetailView.this.jcN.y(j, j2);
                            com.baidu.adp.lib.f.e.mX().postDelayed(TopicDetailView.this.jcO, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.jcK.bh(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.jcK.SW(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.jcK.dJx())) {
                        TopicDetailView.this.qa(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.jcI != null) {
                    TopicDetailView.this.jcI.btD();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.iEj, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.jcP += i2;
                TopicDetailView.this.cCM();
            }
        };
        this.Vz = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bIk();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).ff(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).jcc);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jcA = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.icu == null) {
            this.icu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.icu.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.icu.findViewById(R.id.widget_navi_back_button);
        }
        this.jcB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.bkl().a(this.jcB, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.fHl = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.fHl.a(this.fFF);
        this.jcF = findViewById(R.id.pb_editor_tool_comment);
        this.jcG = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.jcG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cCL();
            }
        });
        this.jcH = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.jcE = findViewById(R.id.activity_topic_detail_editor);
        ar(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.jcI.bsv(), layoutParams);
        this.jcK = new com.baidu.tieba.write.c();
        this.jcJ = findViewById(R.id.activity_topic_detail_editor_top);
        this.iEj = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.iEj.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iEj.setFadingEdgeLength(0);
        this.iEj.setOverScrollMode(2);
        this.iEj.setOnSrollToBottomListener(this.Vz);
        this.iEj.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.iEj, R.color.cp_bg_line_d);
        this.jcD = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.iEj);
        this.jcC = new TopicDetailHeadView(getContext());
        this.jcC.jcy.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void AG(int i) {
                TopicDetailView.this.AF(i);
            }
        });
        if (this.fQf == null) {
            this.fHm = new PbListView(this.mPageContext.getPageActivity());
            this.fHm.getView();
        }
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_e));
        this.fHm.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
        this.fHm.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
        this.fHm.setText(getResources().getString(R.string.list_has_no_more));
        this.fHm.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.jcN == null) {
            this.jcN = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.jcN.l(this.mPageContext.getUniqueId());
        }
    }

    private void ar(Bundle bundle) {
        this.jcI = (a) new b().eb(getContext());
        if (this.jcI != null) {
            this.jcI.a(this.mPageContext);
            this.jcI.b(this.jcR);
            this.jcI.a(this.ePs);
            this.jcI.bsv().jh(true);
            this.jcI.bsv().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.jcI.a((BaseActivity) getContext(), bundle);
            this.jcI.btD();
            this.jcI.bsv().setId(R.id.topic_editor);
            this.jcL = this.jcI.cCK().getInputView();
            this.jcL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.jcK != null) {
                        if (!TopicDetailView.this.jcK.dJA()) {
                            TopicDetailView.this.qa(false);
                        }
                        TopicDetailView.this.jcK.xj(false);
                    }
                }
            });
        }
    }

    public void qa(boolean z) {
        if (this.jcL != null && this.jcL.getText() != null) {
            int selectionEnd = this.jcL.getSelectionEnd();
            SpannableStringBuilder c = this.jcK.c(this.jcL.getText());
            if (c != null) {
                this.jcK.xj(true);
                this.jcL.setText(c);
                if (z && this.jcK.dJy() >= 0) {
                    this.jcL.requestFocus();
                    this.jcL.setSelection(this.jcK.dJy());
                } else {
                    this.jcL.setSelection(selectionEnd);
                }
                this.jcK.xi(this.jcK.dJy() >= 0);
            }
        }
    }

    public void cCL() {
        if (bg.checkUpIsLogin(getContext())) {
            this.jcI.btG();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new aq("c13359").dF("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AF(int i) {
        this.jcM = i;
        this.jcH.setVisibility(0);
        if (i == 1) {
            this.jcH.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.jcH, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.jcH.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.jcH, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.jcH.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.jcH, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.jcH.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.jcH, R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bIj();
            } else if (!this.mHasMore) {
                bIj();
            } else {
                bIi();
            }
            if (!StringUtils.isNull(aVar.ecp)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), at.cutChineseAndEnglishWithSuffix(aVar.ecp, 14, StringHelper.STRING_MORE)));
            }
            this.jcC.setData(aVar.jbU);
            this.iEj.addHeaderView(this.jcC);
            this.jcD.setData(aVar.mDataList);
            if (this.mTopicDetailData.jbU.jbZ != null) {
                if (this.mTopicDetailData.jbU.jbZ.jdt.jdz) {
                    AF(1);
                } else if (this.mTopicDetailData.jbU.jbZ.jdu.jdz) {
                    AF(2);
                } else {
                    AF(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.jcH.setVisibility(8);
            }
            this.jcG.setPadding(dimens, 0, 0, 0);
            cCM();
        }
    }

    public void setNextData(int i, boolean z, List<q> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bIj();
        } else {
            bIi();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).jce = this.mTopicDetailData.cCG();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.iEj.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIk() {
        this.iEj.setNextPage(null);
    }

    public void bIi() {
        this.mHasMore = true;
        this.iEj.setNextPage(this.fHm);
        this.fHm.startLoadData();
    }

    public void bIj() {
        this.iEj.setNextPage(this.fHm);
        this.fHm.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.icu) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jcB && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            blQ();
            TiebaStatic.log(new aq("c13364").dF("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void blQ() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.ecp;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.jbT) ? null : Uri.parse(this.mTopicDetailData.jbT);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.eGs = true;
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
            cCM();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
            ap.setBackgroundResource(this.jcF, R.color.cp_bg_line_h);
            ap.setViewTextColor(this.jcG, R.color.cp_cont_d);
            this.jcG.setBackgroundDrawable(ap.aO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
            AF(this.jcM);
            SvgManager.bkl().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jcB != null) {
                SvgManager.bkl().a(this.jcB, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.fHl != null) {
                this.fHl.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fQf != null) {
                this.fQf.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jcI != null && this.jcI.bsv() != null) {
                this.jcI.bsv().onChangeSkinType(this.mSkinType);
            }
            if (this.fHm != null) {
                this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
                this.fHm.setTextColor(ap.getColor(R.color.cp_cont_e));
                this.fHm.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
                this.fHm.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
            }
            if (this.jcC != null) {
                this.jcC.onChangeSkinType();
            }
            if (this.jcD != null) {
                this.jcD.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.iEj, R.color.cp_bg_line_e);
        }
    }

    public void gR(boolean z) {
        if (!cdE()) {
            if (this.fQf == null) {
                this.fQf = new g(getContext());
                this.fQf.onChangeSkinType();
            }
            this.fQf.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
            this.fQf = null;
        }
    }

    public boolean cdE() {
        if (this.fQf != null) {
            return this.fQf.isViewAttached();
        }
        return false;
    }

    public void nS(boolean z) {
        if (!cdF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.jcA != null) {
                            TopicDetailView.this.jcA.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.iEj.setVisibility(8);
            SvgManager.bkl().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.iEj.setVisibility(0);
        SvgManager.bkl().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cdF() {
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
        this.iEj.setOnSrollToBottomListener(null);
        if (this.fHl != null) {
            this.fHl.b(this.fFF);
        }
        if (this.jcI != null) {
            this.jcI.onDestory();
        }
        if (this.jcO != null) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jcO);
        }
        hideLoadingView();
        bHn();
    }

    public a getEditor() {
        return this.jcI;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.jcJ != null) {
            ViewGroup.LayoutParams layoutParams = this.jcJ.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.jcI.bsv().isVisible()) {
                    layoutParams2.addRule(2, this.jcI.bsv().getId());
                } else {
                    layoutParams2.addRule(2, this.jcE.getId());
                }
                this.jcJ.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aD(bw bwVar) {
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
            cVar2.jcc = cVar.jcc;
            cVar2.dXg = bwVar;
            cVar2.source = 2;
            cVar2.jcd = this.jcM;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.jce = this.mTopicDetailData.cCG();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.jcD.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCM() {
        if (this.mTopicDetailData != null && this.jcC != null) {
            if (this.jcP > this.jcQ) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cCN()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cCN() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.jcC.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.jcC.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
