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
    private BdListView.e TQ;
    private com.baidu.tbadk.editortools.pb.b dYB;
    private NoNetworkView ePl;
    private PbListView ePm;
    private g eYb;
    private NoNetworkView.a gGl;
    private com.baidu.tieba.homepage.topic.topicdetail.a hSc;
    private ImageView hSd;
    private TopicDetailHeadView hSe;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b hSf;
    private View hSg;
    private View hSh;
    private TextView hSi;
    private TextView hSj;
    private a hSk;
    private View hSl;
    private com.baidu.tieba.write.c hSm;
    private EditText hSn;
    private int hSo;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a hSp;
    a.RunnableC0558a hSq;
    private int hSr;
    private int hSs;
    private NewWriteModel.d hSt;
    private View hal;
    private BdTypeRecyclerView hzG;
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
        this.hSh = null;
        this.hSi = null;
        this.hSj = null;
        this.mHasMore = true;
        this.hSr = 0;
        this.hSs = 44;
        this.gGl = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.hSc != null) {
                    TopicDetailView.this.hSc.loadData();
                }
            }
        };
        this.dYB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean aXm() {
                if (TopicDetailView.this.hSm.deU()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.hSm.deW());
                    TopicDetailView.this.nZ(true);
                    return true;
                }
                return false;
            }
        };
        this.hSt = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.hSk != null && TopicDetailView.this.hSk.aWP() != null) {
                    TopicDetailView.this.hSk.aWP().hide();
                }
                if (z) {
                    TopicDetailView.this.hSm.Mp(null);
                    TopicDetailView.this.hSm.aW(null);
                    TopicDetailView.this.hSm.uN(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.hSq = TopicDetailView.this.hSp.B(j, j2);
                            com.baidu.adp.lib.f.e.lb().postDelayed(TopicDetailView.this.hSq, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.hSm.aW(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.hSm.Mp(postWriteCallBackData.getErrorString());
                    if (!v.isEmpty(TopicDetailView.this.hSm.deS())) {
                        TopicDetailView.this.nZ(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.hSk != null) {
                    TopicDetailView.this.hSk.aXO();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.hzG, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.hSr += i2;
                TopicDetailView.this.car();
            }
        };
        this.TQ = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bmq();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).eo(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).hRE);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.hSc = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.hal == null) {
            this.hal = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hal.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.hal.findViewById(R.id.widget_navi_back_button);
        }
        this.hSd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.aOU().a(this.hSd, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.ePl = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.ePl.a(this.gGl);
        this.hSh = findViewById(R.id.pb_editor_tool_comment);
        this.hSi = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.hSi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.caq();
            }
        });
        this.hSj = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.hSg = findViewById(R.id.activity_topic_detail_editor);
        ak(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.hSk.aWP(), layoutParams);
        this.hSm = new com.baidu.tieba.write.c();
        this.hSl = findViewById(R.id.activity_topic_detail_editor_top);
        this.hzG = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.hzG.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hzG.setFadingEdgeLength(0);
        this.hzG.setOverScrollMode(2);
        this.hzG.setOnSrollToBottomListener(this.TQ);
        this.hzG.addOnScrollListener(this.mScrollListener);
        am.setBackgroundColor(this.hzG, R.color.cp_bg_line_d);
        this.hSf = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.hzG);
        this.hSe = new TopicDetailHeadView(getContext());
        this.hSe.hSa.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void wb(int i) {
                TopicDetailView.this.wa(i);
            }
        });
        if (this.eYb == null) {
            this.ePm = new PbListView(this.mPageContext.getPageActivity());
            this.ePm.getView();
        }
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_e));
        this.ePm.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
        this.ePm.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
        this.ePm.setText(getResources().getString(R.string.list_has_no_more));
        this.ePm.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.hSp == null) {
            this.hSp = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.hSp.j(this.mPageContext.getUniqueId());
        }
    }

    private void ak(Bundle bundle) {
        this.hSk = (a) new b().dI(getContext());
        if (this.hSk != null) {
            this.hSk.a(this.mPageContext);
            this.hSk.b(this.hSt);
            this.hSk.a(this.dYB);
            this.hSk.aWP().hA(true);
            this.hSk.aWP().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.hSk.a((BaseActivity) getContext(), bundle);
            this.hSk.aXO();
            this.hSk.aWP().setId(R.id.topic_editor);
            this.hSn = this.hSk.cap().getInputView();
            this.hSn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.hSm != null) {
                        if (!TopicDetailView.this.hSm.deV()) {
                            TopicDetailView.this.nZ(false);
                        }
                        TopicDetailView.this.hSm.uO(false);
                    }
                }
            });
        }
    }

    public void nZ(boolean z) {
        if (this.hSn != null && this.hSn.getText() != null) {
            int selectionEnd = this.hSn.getSelectionEnd();
            SpannableStringBuilder a = this.hSm.a(this.hSn.getText());
            if (a != null) {
                this.hSm.uO(true);
                this.hSn.setText(a);
                if (z && this.hSm.deT() >= 0) {
                    this.hSn.requestFocus();
                    this.hSn.setSelection(this.hSm.deT());
                } else {
                    this.hSn.setSelection(selectionEnd);
                }
                this.hSm.uN(this.hSm.deT() >= 0);
            }
        }
    }

    public void caq() {
        if (bc.checkUpIsLogin(getContext())) {
            this.hSk.aXR();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new an("c13359").cI("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(int i) {
        this.hSo = i;
        this.hSj.setVisibility(0);
        if (i == 1) {
            this.hSj.setText(R.string.topic_detail_pk_support);
            am.setBackgroundResource(this.hSj, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.hSj.setText(R.string.topic_detail_pk_oppose);
            am.setBackgroundResource(this.hSj, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.hSj.setText(R.string.topic_detail_pk_chigua);
            am.setBackgroundResource(this.hSj, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.hSj.setTextColor(-2130706433);
        } else {
            am.setViewTextColor(this.hSj, (int) R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bmp();
            } else if (!this.mHasMore) {
                bmp();
            } else {
                bmo();
            }
            if (!StringUtils.isNull(aVar.dpV)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), aq.cutChineseAndEnglishWithSuffix(aVar.dpV, 14, StringHelper.STRING_MORE)));
            }
            this.hSe.setData(aVar.hRw);
            this.hzG.addHeaderView(this.hSe);
            this.hSf.setData(aVar.mDataList);
            if (this.mTopicDetailData.hRw.hRB != null) {
                if (this.mTopicDetailData.hRw.hRB.hSW.hTc) {
                    wa(1);
                } else if (this.mTopicDetailData.hRw.hRB.hSX.hTc) {
                    wa(2);
                } else {
                    wa(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.hSj.setVisibility(8);
            }
            this.hSi.setPadding(dimens, 0, 0, 0);
            car();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bmp();
        } else {
            bmo();
        }
        if (i == 0 && list != null && !v.isEmpty(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).hRG = this.mTopicDetailData.cak();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.hzG.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmq() {
        this.hzG.setNextPage(null);
    }

    public void bmo() {
        this.mHasMore = true;
        this.hzG.setNextPage(this.ePm);
        this.ePm.startLoadData();
    }

    public void bmp() {
        this.hzG.setNextPage(this.ePm);
        this.ePm.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hal) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.hSd && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            aQD();
            TiebaStatic.log(new an("c13364").cI("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aQD() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.dpV;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.hRv) ? null : Uri.parse(this.mTopicDetailData.hRv);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.dQo = true;
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
            car();
            am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.hSh, R.color.cp_bg_line_h);
            am.setViewTextColor(this.hSi, (int) R.color.cp_cont_d);
            this.hSi.setBackgroundDrawable(am.aB(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
            wa(this.hSo);
            SvgManager.aOU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.hSd != null) {
                SvgManager.aOU().a(this.hSd, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.ePl != null) {
                this.ePl.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.eYb != null) {
                this.eYb.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hSk != null && this.hSk.aWP() != null) {
                this.hSk.aWP().onChangeSkinType(this.mSkinType);
            }
            if (this.ePm != null) {
                this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
                this.ePm.setTextColor(am.getColor(R.color.cp_cont_e));
                this.ePm.setContainerBackgroundColorResId(am.getColor(R.color.cp_bg_line_d));
                this.ePm.setLineColorResource(am.getColor(R.color.cp_bg_line_c));
            }
            if (this.hSe != null) {
                this.hSe.onChangeSkinType();
            }
            if (this.hSf != null) {
                this.hSf.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.hzG, R.color.cp_bg_line_e);
        }
    }

    public void fK(boolean z) {
        if (!bJt()) {
            if (this.eYb == null) {
                this.eYb = new g(getContext());
                this.eYb.onChangeSkinType();
            }
            this.eYb.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this);
            this.eYb = null;
        }
    }

    public boolean bJt() {
        if (this.eYb != null) {
            return this.eYb.isViewAttached();
        }
        return false;
    }

    public void lV(boolean z) {
        if (!bJu()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.hSc != null) {
                            TopicDetailView.this.hSc.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.hzG.setVisibility(8);
            SvgManager.aOU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void blt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.hzG.setVisibility(0);
        SvgManager.aOU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bJu() {
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
        this.hzG.setOnSrollToBottomListener(null);
        if (this.ePl != null) {
            this.ePl.b(this.gGl);
        }
        if (this.hSk != null) {
            this.hSk.onDestory();
        }
        if (this.hSq != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hSq);
        }
        hideLoadingView();
        blt();
    }

    public a getEditor() {
        return this.hSk;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.hSl != null) {
            ViewGroup.LayoutParams layoutParams = this.hSl.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.hSk.aWP().isVisible()) {
                    layoutParams2.addRule(2, this.hSk.aWP().getId());
                } else {
                    layoutParams2.addRule(2, this.hSg.getId());
                }
                this.hSl.setLayoutParams(layoutParams2);
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
            cVar2.hRE = cVar.hRE;
            cVar2.dqA = bjVar;
            cVar2.source = 2;
            cVar2.hRF = this.hSo;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.hRG = this.mTopicDetailData.cak();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.hSf.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void car() {
        if (this.mTopicDetailData != null && this.hSe != null) {
            if (this.hSr > this.hSs) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cas()));
                return;
            }
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cas() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.hSe.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.hSe.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
