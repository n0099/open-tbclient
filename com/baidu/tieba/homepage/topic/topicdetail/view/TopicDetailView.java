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
    private com.baidu.tbadk.editortools.pb.b eMB;
    private NoNetworkView.a fCt;
    private NoNetworkView fDZ;
    private PbListView fEa;
    private g fMR;
    private View hVu;
    private com.baidu.tieba.homepage.topic.topicdetail.a iTU;
    private ImageView iTV;
    private TopicDetailHeadView iTW;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b iTX;
    private View iTY;
    private View iTZ;
    private TextView iUa;
    private TextView iUb;
    private a iUc;
    private View iUd;
    private com.baidu.tieba.write.c iUe;
    private EditText iUf;
    private int iUg;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a iUh;
    a.RunnableC0701a iUi;
    private int iUj;
    private int iUk;
    private NewWriteModel.d iUl;
    private BdTypeRecyclerView iwN;
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
        this.iTZ = null;
        this.iUa = null;
        this.iUb = null;
        this.mHasMore = true;
        this.iUj = 0;
        this.iUk = 44;
        this.fCt = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.iTU != null) {
                    TopicDetailView.this.iTU.loadData();
                }
            }
        };
        this.eMB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean brV() {
                if (TopicDetailView.this.iUe.dFF()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.iUe.dFH());
                    TopicDetailView.this.pS(true);
                    return true;
                }
                return false;
            }
        };
        this.iUl = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.iUc != null && TopicDetailView.this.iUc.brw() != null) {
                    TopicDetailView.this.iUc.brw().hide();
                }
                if (z) {
                    TopicDetailView.this.iUe.Sw(null);
                    TopicDetailView.this.iUe.bf(null);
                    TopicDetailView.this.iUe.wZ(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.iUi = TopicDetailView.this.iUh.B(j, j2);
                            com.baidu.adp.lib.f.e.mS().postDelayed(TopicDetailView.this.iUi, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.iUe.bf(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.iUe.Sw(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.iUe.dFD())) {
                        TopicDetailView.this.pS(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.iUc != null) {
                    TopicDetailView.this.iUc.bsz();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.iwN, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.iUj += i2;
                TopicDetailView.this.czf();
            }
        };
        this.Vh = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bGU();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).eR(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).iTw);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iTU = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.hVu == null) {
            this.hVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hVu.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.hVu.findViewById(R.id.widget_navi_back_button);
        }
        this.iTV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.bjq().a(this.iTV, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.fDZ = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.fDZ.a(this.fCt);
        this.iTZ = findViewById(R.id.pb_editor_tool_comment);
        this.iUa = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.iUa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cze();
            }
        });
        this.iUb = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.iTY = findViewById(R.id.activity_topic_detail_editor);
        ar(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.iUc.brw(), layoutParams);
        this.iUe = new com.baidu.tieba.write.c();
        this.iUd = findViewById(R.id.activity_topic_detail_editor_top);
        this.iwN = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.iwN.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iwN.setFadingEdgeLength(0);
        this.iwN.setOverScrollMode(2);
        this.iwN.setOnSrollToBottomListener(this.Vh);
        this.iwN.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.iwN, R.color.cp_bg_line_d);
        this.iTX = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.iwN);
        this.iTW = new TopicDetailHeadView(getContext());
        this.iTW.iTS.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void Af(int i) {
                TopicDetailView.this.Ae(i);
            }
        });
        if (this.fMR == null) {
            this.fEa = new PbListView(this.mPageContext.getPageActivity());
            this.fEa.getView();
        }
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_e));
        this.fEa.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
        this.fEa.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
        this.fEa.setText(getResources().getString(R.string.list_has_no_more));
        this.fEa.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.iUh == null) {
            this.iUh = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.iUh.m(this.mPageContext.getUniqueId());
        }
    }

    private void ar(Bundle bundle) {
        this.iUc = (a) new b().ec(getContext());
        if (this.iUc != null) {
            this.iUc.a(this.mPageContext);
            this.iUc.b(this.iUl);
            this.iUc.a(this.eMB);
            this.iUc.brw().jj(true);
            this.iUc.brw().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.iUc.a((BaseActivity) getContext(), bundle);
            this.iUc.bsz();
            this.iUc.brw().setId(R.id.topic_editor);
            this.iUf = this.iUc.czd().getInputView();
            this.iUf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.iUe != null) {
                        if (!TopicDetailView.this.iUe.dFG()) {
                            TopicDetailView.this.pS(false);
                        }
                        TopicDetailView.this.iUe.xa(false);
                    }
                }
            });
        }
    }

    public void pS(boolean z) {
        if (this.iUf != null && this.iUf.getText() != null) {
            int selectionEnd = this.iUf.getSelectionEnd();
            SpannableStringBuilder c = this.iUe.c(this.iUf.getText());
            if (c != null) {
                this.iUe.xa(true);
                this.iUf.setText(c);
                if (z && this.iUe.dFE() >= 0) {
                    this.iUf.requestFocus();
                    this.iUf.setSelection(this.iUe.dFE());
                } else {
                    this.iUf.setSelection(selectionEnd);
                }
                this.iUe.wZ(this.iUe.dFE() >= 0);
            }
        }
    }

    public void cze() {
        if (bg.checkUpIsLogin(getContext())) {
            this.iUc.bsC();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new aq("c13359").dD("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ae(int i) {
        this.iUg = i;
        this.iUb.setVisibility(0);
        if (i == 1) {
            this.iUb.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.iUb, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.iUb.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.iUb, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.iUb.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.iUb, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.iUb.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.iUb, R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bGT();
            } else if (!this.mHasMore) {
                bGT();
            } else {
                bGS();
            }
            if (!StringUtils.isNull(aVar.eaf)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), at.cutChineseAndEnglishWithSuffix(aVar.eaf, 14, StringHelper.STRING_MORE)));
            }
            this.iTW.setData(aVar.iTo);
            this.iwN.addHeaderView(this.iTW);
            this.iTX.setData(aVar.mDataList);
            if (this.mTopicDetailData.iTo.iTt != null) {
                if (this.mTopicDetailData.iTo.iTt.iUN.iUT) {
                    Ae(1);
                } else if (this.mTopicDetailData.iTo.iTt.iUO.iUT) {
                    Ae(2);
                } else {
                    Ae(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.iUb.setVisibility(8);
            }
            this.iUa.setPadding(dimens, 0, 0, 0);
            czf();
        }
    }

    public void setNextData(int i, boolean z, List<q> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bGT();
        } else {
            bGS();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).iTy = this.mTopicDetailData.cyZ();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.iwN.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGU() {
        this.iwN.setNextPage(null);
    }

    public void bGS() {
        this.mHasMore = true;
        this.iwN.setNextPage(this.fEa);
        this.fEa.startLoadData();
    }

    public void bGT() {
        this.iwN.setNextPage(this.fEa);
        this.fEa.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hVu) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.iTV && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            bkV();
            TiebaStatic.log(new aq("c13364").dD("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void bkV() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.eaf;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.iTn) ? null : Uri.parse(this.mTopicDetailData.iTn);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.eEm = true;
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
            czf();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
            ap.setBackgroundResource(this.iTZ, R.color.cp_bg_line_h);
            ap.setViewTextColor(this.iUa, R.color.cp_cont_d);
            this.iUa.setBackgroundDrawable(ap.aO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
            Ae(this.iUg);
            SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.iTV != null) {
                SvgManager.bjq().a(this.iTV, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.fDZ != null) {
                this.fDZ.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fMR != null) {
                this.fMR.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iUc != null && this.iUc.brw() != null) {
                this.iUc.brw().onChangeSkinType(this.mSkinType);
            }
            if (this.fEa != null) {
                this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
                this.fEa.setTextColor(ap.getColor(R.color.cp_cont_e));
                this.fEa.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
                this.fEa.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
            }
            if (this.iTW != null) {
                this.iTW.onChangeSkinType();
            }
            if (this.iTX != null) {
                this.iTX.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.iwN, R.color.cp_bg_line_e);
        }
    }

    public void gT(boolean z) {
        if (!cgw()) {
            if (this.fMR == null) {
                this.fMR = new g(getContext());
                this.fMR.onChangeSkinType();
            }
            this.fMR.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this);
            this.fMR = null;
        }
    }

    public boolean cgw() {
        if (this.fMR != null) {
            return this.fMR.isViewAttached();
        }
        return false;
    }

    public void nM(boolean z) {
        if (!cgx()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.iTU != null) {
                            TopicDetailView.this.iTU.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.iwN.setVisibility(8);
            SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.iwN.setVisibility(0);
        SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cgx() {
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
        this.iwN.setOnSrollToBottomListener(null);
        if (this.fDZ != null) {
            this.fDZ.b(this.fCt);
        }
        if (this.iUc != null) {
            this.iUc.onDestory();
        }
        if (this.iUi != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iUi);
        }
        hideLoadingView();
        bFX();
    }

    public a getEditor() {
        return this.iUc;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.iUd != null) {
            ViewGroup.LayoutParams layoutParams = this.iUd.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.iUc.brw().isVisible()) {
                    layoutParams2.addRule(2, this.iUc.brw().getId());
                } else {
                    layoutParams2.addRule(2, this.iTY.getId());
                }
                this.iUd.setLayoutParams(layoutParams2);
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
            cVar2.iTw = cVar.iTw;
            cVar2.dUW = bwVar;
            cVar2.source = 2;
            cVar2.iTx = this.iUg;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.iTy = this.mTopicDetailData.cyZ();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.iTX.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czf() {
        if (this.mTopicDetailData != null && this.iTW != null) {
            if (this.iUj > this.iUk) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(czg()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap czg() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.iTW.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.iTW.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
