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
/* loaded from: classes22.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e VR;
    private com.baidu.tbadk.editortools.pb.b fpQ;
    private NoNetworkView.a ghG;
    private NoNetworkView gjn;
    private PbListView gjo;
    private g gso;
    private View iJO;
    private com.baidu.tieba.homepage.topic.topicdetail.a jJX;
    private ImageView jJY;
    private TopicDetailHeadView jJZ;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b jKa;
    private View jKb;
    private View jKc;
    private TextView jKd;
    private TextView jKe;
    private a jKf;
    private View jKg;
    private com.baidu.tieba.write.c jKh;
    private EditText jKi;
    private int jKj;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a jKk;
    a.RunnableC0746a jKl;
    private int jKm;
    private int jKn;
    private NewWriteModel.d jKo;
    private BdTypeRecyclerView jlt;
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
        this.jKc = null;
        this.jKd = null;
        this.jKe = null;
        this.mHasMore = true;
        this.jKm = 0;
        this.jKn = 44;
        this.ghG = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.jJX != null) {
                    TopicDetailView.this.jJX.loadData();
                }
            }
        };
        this.fpQ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bAb() {
                if (TopicDetailView.this.jKh.dSV()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.jKh.dSX());
                    TopicDetailView.this.rh(true);
                    return true;
                }
                return false;
            }
        };
        this.jKo = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.jKf != null && TopicDetailView.this.jKf.bzx() != null) {
                    TopicDetailView.this.jKf.bzx().hide();
                }
                if (z) {
                    TopicDetailView.this.jKh.UA(null);
                    TopicDetailView.this.jKh.bk(null);
                    TopicDetailView.this.jKh.yp(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.jKl = TopicDetailView.this.jKk.A(j, j2);
                            com.baidu.adp.lib.f.e.mY().postDelayed(TopicDetailView.this.jKl, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.jKh.bk(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.jKh.UA(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.jKh.dST())) {
                        TopicDetailView.this.rh(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.jKf != null) {
                    TopicDetailView.this.jKf.bAF();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.jlt, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.jKm += i2;
                TopicDetailView.this.cMd();
            }
        };
        this.VR = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bPW();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).fU(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).jJy);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jJX = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.iJO == null) {
            this.iJO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iJO.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.iJO.findViewById(R.id.widget_navi_back_button);
        }
        this.jJY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.brn().a(this.jJY, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.gjn = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.gjn.a(this.ghG);
        this.jKc = findViewById(R.id.pb_editor_tool_comment);
        this.jKd = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.jKd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cMc();
            }
        });
        this.jKe = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.jKb = findViewById(R.id.activity_topic_detail_editor);
        ar(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.jKf.bzx(), layoutParams);
        this.jKh = new com.baidu.tieba.write.c();
        this.jKg = findViewById(R.id.activity_topic_detail_editor_top);
        this.jlt = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.jlt.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jlt.setFadingEdgeLength(0);
        this.jlt.setOverScrollMode(2);
        this.jlt.setOnSrollToBottomListener(this.VR);
        this.jlt.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.jlt, R.color.cp_bg_line_d);
        this.jKa = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.jlt);
        this.jJZ = new TopicDetailHeadView(getContext());
        this.jJZ.jJV.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void BS(int i) {
                TopicDetailView.this.BR(i);
            }
        });
        if (this.gso == null) {
            this.gjo = new PbListView(this.mPageContext.getPageActivity());
            this.gjo.getView();
        }
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_e));
        this.gjo.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
        this.gjo.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
        this.gjo.setText(getResources().getString(R.string.list_has_no_more));
        this.gjo.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.jKk == null) {
            this.jKk = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.jKk.l(this.mPageContext.getUniqueId());
        }
    }

    private void ar(Bundle bundle) {
        this.jKf = (a) new b().ei(getContext());
        if (this.jKf != null) {
            this.jKf.a(this.mPageContext);
            this.jKf.b(this.jKo);
            this.jKf.a(this.fpQ);
            this.jKf.bzx().kb(true);
            this.jKf.bzx().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.jKf.a((BaseActivity) getContext(), bundle);
            this.jKf.bAF();
            this.jKf.bzx().setId(R.id.topic_editor);
            this.jKi = this.jKf.cMb().getInputView();
            this.jKi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.jKh != null) {
                        if (!TopicDetailView.this.jKh.dSW()) {
                            TopicDetailView.this.rh(false);
                        }
                        TopicDetailView.this.jKh.yq(false);
                    }
                }
            });
        }
    }

    public void rh(boolean z) {
        if (this.jKi != null && this.jKi.getText() != null) {
            int selectionEnd = this.jKi.getSelectionEnd();
            SpannableStringBuilder c = this.jKh.c(this.jKi.getText());
            if (c != null) {
                this.jKh.yq(true);
                this.jKi.setText(c);
                if (z && this.jKh.dSU() >= 0) {
                    this.jKi.requestFocus();
                    this.jKi.setSelection(this.jKh.dSU());
                } else {
                    this.jKi.setSelection(selectionEnd);
                }
                this.jKh.yp(this.jKh.dSU() >= 0);
            }
        }
    }

    public void cMc() {
        if (bg.checkUpIsLogin(getContext())) {
            this.jKf.bAI();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new aq("c13359").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR(int i) {
        this.jKj = i;
        this.jKe.setVisibility(0);
        if (i == 1) {
            this.jKe.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.jKe, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.jKe.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.jKe, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.jKe.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.jKe, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.jKe.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.jKe, R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                Wj();
            } else if (!this.mHasMore) {
                Wj();
            } else {
                Wi();
            }
            if (!StringUtils.isNull(aVar.eCJ)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), at.cutChineseAndEnglishWithSuffix(aVar.eCJ, 14, StringHelper.STRING_MORE)));
            }
            this.jJZ.setData(aVar.jJq);
            this.jlt.addHeaderView(this.jJZ);
            this.jKa.setData(aVar.mDataList);
            if (this.mTopicDetailData.jJq.jJv != null) {
                if (this.mTopicDetailData.jJq.jJv.jKQ.jKW) {
                    BR(1);
                } else if (this.mTopicDetailData.jJq.jJv.jKR.jKW) {
                    BR(2);
                } else {
                    BR(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.jKe.setVisibility(8);
            }
            this.jKd.setPadding(dimens, 0, 0, 0);
            cMd();
        }
    }

    public void setNextData(int i, boolean z, List<q> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            Wj();
        } else {
            Wi();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).jJA = this.mTopicDetailData.cLX();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.jlt.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPW() {
        this.jlt.setNextPage(null);
    }

    public void Wi() {
        this.mHasMore = true;
        this.jlt.setNextPage(this.gjo);
        this.gjo.startLoadData();
    }

    public void Wj() {
        this.jlt.setNextPage(this.gjo);
        this.gjo.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iJO) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jJY && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            bsT();
            TiebaStatic.log(new aq("c13364").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void bsT() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.eCJ;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.jJp) ? null : Uri.parse(this.mTopicDetailData.jJp);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.fgM = true;
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
            cMd();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
            ap.setBackgroundResource(this.jKc, R.color.cp_bg_line_h);
            ap.setViewTextColor(this.jKd, R.color.cp_cont_d);
            this.jKd.setBackgroundDrawable(ap.aO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
            BR(this.jKj);
            SvgManager.brn().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jJY != null) {
                SvgManager.brn().a(this.jJY, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.gjn != null) {
                this.gjn.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gso != null) {
                this.gso.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jKf != null && this.jKf.bzx() != null) {
                this.jKf.bzx().onChangeSkinType(this.mSkinType);
            }
            if (this.gjo != null) {
                this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
                this.gjo.setTextColor(ap.getColor(R.color.cp_cont_e));
                this.gjo.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
                this.gjo.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
            }
            if (this.jJZ != null) {
                this.jJZ.onChangeSkinType();
            }
            if (this.jKa != null) {
                this.jKa.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.jlt, R.color.cp_bg_line_e);
        }
    }

    public void hJ(boolean z) {
        if (!cmJ()) {
            if (this.gso == null) {
                this.gso = new g(getContext());
                this.gso.onChangeSkinType();
            }
            this.gso.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
            this.gso = null;
        }
    }

    public boolean cmJ() {
        if (this.gso != null) {
            return this.gso.isViewAttached();
        }
        return false;
    }

    public void oY(boolean z) {
        if (!cmK()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.jJX != null) {
                            TopicDetailView.this.jJX.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jlt.setVisibility(8);
            SvgManager.brn().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.jlt.setVisibility(0);
        SvgManager.brn().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cmK() {
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
        this.jlt.setOnSrollToBottomListener(null);
        if (this.gjn != null) {
            this.gjn.b(this.ghG);
        }
        if (this.jKf != null) {
            this.jKf.onDestory();
        }
        if (this.jKl != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jKl);
        }
        hideLoadingView();
        Wk();
    }

    public a getEditor() {
        return this.jKf;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.jKg != null) {
            ViewGroup.LayoutParams layoutParams = this.jKg.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.jKf.bzx().isVisible()) {
                    layoutParams2.addRule(2, this.jKf.bzx().getId());
                } else {
                    layoutParams2.addRule(2, this.jKb.getId());
                }
                this.jKg.setLayoutParams(layoutParams2);
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
            cVar2.jJy = cVar.jJy;
            cVar2.exA = bwVar;
            cVar2.source = 2;
            cVar2.jJz = this.jKj;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.jJA = this.mTopicDetailData.cLX();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.jKa.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMd() {
        if (this.mTopicDetailData != null && this.jJZ != null) {
            if (this.jKm > this.jKn) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cMe()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cMe() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.jJZ.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.jJZ.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
