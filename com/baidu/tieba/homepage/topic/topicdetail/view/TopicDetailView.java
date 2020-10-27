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
    private com.baidu.tbadk.editortools.pb.b fjY;
    private NoNetworkView.a gbR;
    private NoNetworkView gdx;
    private PbListView gdy;
    private g gmB;
    private View iDR;
    private com.baidu.tieba.homepage.topic.topicdetail.a jDZ;
    private ImageView jEa;
    private TopicDetailHeadView jEb;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b jEc;
    private View jEd;
    private View jEe;
    private TextView jEf;
    private TextView jEg;
    private a jEh;
    private View jEi;
    private com.baidu.tieba.write.c jEj;
    private EditText jEk;
    private int jEl;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a jEm;
    a.RunnableC0732a jEn;
    private int jEo;
    private int jEp;
    private NewWriteModel.d jEq;
    private BdTypeRecyclerView jfv;
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
        this.jEe = null;
        this.jEf = null;
        this.jEg = null;
        this.mHasMore = true;
        this.jEo = 0;
        this.jEp = 44;
        this.gbR = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.jDZ != null) {
                    TopicDetailView.this.jDZ.loadData();
                }
            }
        };
        this.fjY = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bxC() {
                if (TopicDetailView.this.jEj.dQt()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.jEj.dQv());
                    TopicDetailView.this.qY(true);
                    return true;
                }
                return false;
            }
        };
        this.jEq = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.jEh != null && TopicDetailView.this.jEh.bwY() != null) {
                    TopicDetailView.this.jEh.bwY().hide();
                }
                if (z) {
                    TopicDetailView.this.jEj.Uj(null);
                    TopicDetailView.this.jEj.bk(null);
                    TopicDetailView.this.jEj.yg(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.jEn = TopicDetailView.this.jEm.z(j, j2);
                            com.baidu.adp.lib.f.e.mY().postDelayed(TopicDetailView.this.jEn, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.jEj.bk(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.jEj.Uj(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.jEj.dQr())) {
                        TopicDetailView.this.qY(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.jEh != null) {
                    TopicDetailView.this.jEh.byg();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.jfv, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.jEo += i2;
                TopicDetailView.this.cJC();
            }
        };
        this.VR = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bNw();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).fy(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).jDB);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jDZ = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.iDR == null) {
            this.iDR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iDR.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.iDR.findViewById(R.id.widget_navi_back_button);
        }
        this.jEa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.boN().a(this.jEa, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.gdx = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.gdx.a(this.gbR);
        this.jEe = findViewById(R.id.pb_editor_tool_comment);
        this.jEf = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.jEf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cJB();
            }
        });
        this.jEg = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.jEd = findViewById(R.id.activity_topic_detail_editor);
        ar(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.jEh.bwY(), layoutParams);
        this.jEj = new com.baidu.tieba.write.c();
        this.jEi = findViewById(R.id.activity_topic_detail_editor_top);
        this.jfv = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.jfv.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jfv.setFadingEdgeLength(0);
        this.jfv.setOverScrollMode(2);
        this.jfv.setOnSrollToBottomListener(this.VR);
        this.jfv.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.jfv, R.color.cp_bg_line_d);
        this.jEc = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.jfv);
        this.jEb = new TopicDetailHeadView(getContext());
        this.jEb.jDX.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void BF(int i) {
                TopicDetailView.this.BE(i);
            }
        });
        if (this.gmB == null) {
            this.gdy = new PbListView(this.mPageContext.getPageActivity());
            this.gdy.getView();
        }
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_e));
        this.gdy.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
        this.gdy.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
        this.gdy.setText(getResources().getString(R.string.list_has_no_more));
        this.gdy.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.jEm == null) {
            this.jEm = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.jEm.l(this.mPageContext.getUniqueId());
        }
    }

    private void ar(Bundle bundle) {
        this.jEh = (a) new b().ei(getContext());
        if (this.jEh != null) {
            this.jEh.a(this.mPageContext);
            this.jEh.b(this.jEq);
            this.jEh.a(this.fjY);
            this.jEh.bwY().jS(true);
            this.jEh.bwY().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.jEh.a((BaseActivity) getContext(), bundle);
            this.jEh.byg();
            this.jEh.bwY().setId(R.id.topic_editor);
            this.jEk = this.jEh.cJA().getInputView();
            this.jEk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.jEj != null) {
                        if (!TopicDetailView.this.jEj.dQu()) {
                            TopicDetailView.this.qY(false);
                        }
                        TopicDetailView.this.jEj.yh(false);
                    }
                }
            });
        }
    }

    public void qY(boolean z) {
        if (this.jEk != null && this.jEk.getText() != null) {
            int selectionEnd = this.jEk.getSelectionEnd();
            SpannableStringBuilder c = this.jEj.c(this.jEk.getText());
            if (c != null) {
                this.jEj.yh(true);
                this.jEk.setText(c);
                if (z && this.jEj.dQs() >= 0) {
                    this.jEk.requestFocus();
                    this.jEk.setSelection(this.jEj.dQs());
                } else {
                    this.jEk.setSelection(selectionEnd);
                }
                this.jEj.yg(this.jEj.dQs() >= 0);
            }
        }
    }

    public void cJB() {
        if (bg.checkUpIsLogin(getContext())) {
            this.jEh.byj();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new aq("c13359").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BE(int i) {
        this.jEl = i;
        this.jEg.setVisibility(0);
        if (i == 1) {
            this.jEg.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.jEg, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.jEg.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.jEg, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.jEg.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.jEg, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.jEg.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.jEg, R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                TJ();
            } else if (!this.mHasMore) {
                TJ();
            } else {
                TI();
            }
            if (!StringUtils.isNull(aVar.ewR)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), at.cutChineseAndEnglishWithSuffix(aVar.ewR, 14, StringHelper.STRING_MORE)));
            }
            this.jEb.setData(aVar.jDt);
            this.jfv.addHeaderView(this.jEb);
            this.jEc.setData(aVar.mDataList);
            if (this.mTopicDetailData.jDt.jDy != null) {
                if (this.mTopicDetailData.jDt.jDy.jES.jEY) {
                    BE(1);
                } else if (this.mTopicDetailData.jDt.jDy.jET.jEY) {
                    BE(2);
                } else {
                    BE(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.jEg.setVisibility(8);
            }
            this.jEf.setPadding(dimens, 0, 0, 0);
            cJC();
        }
    }

    public void setNextData(int i, boolean z, List<q> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            TJ();
        } else {
            TI();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).jDD = this.mTopicDetailData.cJw();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.jfv.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNw() {
        this.jfv.setNextPage(null);
    }

    public void TI() {
        this.mHasMore = true;
        this.jfv.setNextPage(this.gdy);
        this.gdy.startLoadData();
    }

    public void TJ() {
        this.jfv.setNextPage(this.gdy);
        this.gdy.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iDR) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jEa && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            bqt();
            TiebaStatic.log(new aq("c13364").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void bqt() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.ewR;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.jDs) ? null : Uri.parse(this.mTopicDetailData.jDs);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.faV = true;
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
            cJC();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
            ap.setBackgroundResource(this.jEe, R.color.cp_bg_line_h);
            ap.setViewTextColor(this.jEf, R.color.cp_cont_d);
            this.jEf.setBackgroundDrawable(ap.aO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
            BE(this.jEl);
            SvgManager.boN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jEa != null) {
                SvgManager.boN().a(this.jEa, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.gdx != null) {
                this.gdx.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gmB != null) {
                this.gmB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jEh != null && this.jEh.bwY() != null) {
                this.jEh.bwY().onChangeSkinType(this.mSkinType);
            }
            if (this.gdy != null) {
                this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
                this.gdy.setTextColor(ap.getColor(R.color.cp_cont_e));
                this.gdy.setContainerBackgroundColorResId(ap.getColor(R.color.cp_bg_line_d));
                this.gdy.setLineColorResource(ap.getColor(R.color.cp_bg_line_c));
            }
            if (this.jEb != null) {
                this.jEb.onChangeSkinType();
            }
            if (this.jEc != null) {
                this.jEc.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.jfv, R.color.cp_bg_line_e);
        }
    }

    public void hA(boolean z) {
        if (!ckh()) {
            if (this.gmB == null) {
                this.gmB = new g(getContext());
                this.gmB.onChangeSkinType();
            }
            this.gmB.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this);
            this.gmB = null;
        }
    }

    public boolean ckh() {
        if (this.gmB != null) {
            return this.gmB.isViewAttached();
        }
        return false;
    }

    public void oP(boolean z) {
        if (!cki()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.jDZ != null) {
                            TopicDetailView.this.jDZ.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jfv.setVisibility(8);
            SvgManager.boN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.jfv.setVisibility(0);
        SvgManager.boN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cki() {
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
        this.jfv.setOnSrollToBottomListener(null);
        if (this.gdx != null) {
            this.gdx.b(this.gbR);
        }
        if (this.jEh != null) {
            this.jEh.onDestory();
        }
        if (this.jEn != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jEn);
        }
        hideLoadingView();
        TK();
    }

    public a getEditor() {
        return this.jEh;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.jEi != null) {
            ViewGroup.LayoutParams layoutParams = this.jEi.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.jEh.bwY().isVisible()) {
                    layoutParams2.addRule(2, this.jEh.bwY().getId());
                } else {
                    layoutParams2.addRule(2, this.jEd.getId());
                }
                this.jEi.setLayoutParams(layoutParams2);
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
            cVar2.jDB = cVar.jDB;
            cVar2.erH = bwVar;
            cVar2.source = 2;
            cVar2.jDC = this.jEl;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.jDD = this.mTopicDetailData.cJw();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.jEc.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJC() {
        if (this.mTopicDetailData != null && this.jEb != null) {
            if (this.jEo > this.jEp) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cJD()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cJD() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.jEb.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.jEb.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
