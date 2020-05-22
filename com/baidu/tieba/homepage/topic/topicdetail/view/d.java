package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean aha;
    private TbPageContext dIF;
    private TextView dXU;
    private ConstrainImageGroup gEm;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c ihl;
    private ClickableHeaderImageView ihm;
    private ImageView ihn;
    private TextView iho;
    private AgreeView ihp;
    private TextView ihq;
    private ImageView ihr;
    private TbRichTextView ihs;
    private RelativeLayout iht;
    private View ihu;
    private TbImageView ihv;
    private TextView ihw;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aha = true;
        this.mSkinType = 3;
        this.dIF = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.ihm = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.ihn = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.dXU = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.iho = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.ihs = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.ihs.setClickable(true);
        this.ihs.setTextEllipsize(TextUtils.TruncateAt.END);
        this.ihs.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.ihs.setLayoutStrategy(aVar);
        this.iht = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.gEm = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.gEm.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.o(1.0d);
        this.gEm.setImageProcessor(aVar2);
        this.ihp = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.ihp.aVN();
        this.ihq = (TextView) view.findViewById(R.id.topic_comment_number);
        this.ihr = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.ihu = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.ihv = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.ihv.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.ihv.setConrers(5);
        this.ihv.setDrawCorner(true);
        this.ihw = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.dXU.setOnClickListener(this);
        this.ihq.setOnClickListener(this);
        this.ihr.setOnClickListener(this);
        this.ihs.setOnClickListener(this);
        this.ihu.setOnClickListener(this);
        this.ihw.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gEm != null) {
            this.gEm.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gEm != null) {
            this.gEm.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.ihl != null) {
            this.mSkinType = i;
            this.ihm.setIsNight(this.mSkinType == 1);
            if (this.ihl.igw) {
                if (this.ihl.igv == 1) {
                    am.setImageResource(this.ihn, R.drawable.label_topic_agree_red);
                    this.ihm.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.ihl.igv == 2) {
                    am.setImageResource(this.ihn, R.drawable.label_topic_disagree_blue);
                    this.ihm.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.ihn, R.drawable.label_topic_eat_black);
                    this.ihm.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.dXU, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.iho, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ihq, (int) R.color.cp_cont_j);
            if (this.ihr != null) {
                SvgManager.aUV().a(this.ihr, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.ihp.onChangeSkinType(i);
            this.ihs.setTextColor(am.getColor(R.color.cp_cont_b));
            am.c(this.ihu, l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.ihw, (int) R.color.cp_cont_d);
            this.gEm.onChangeSkinType();
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        String name_show;
        String formatTime;
        int aQo;
        AgreeData aSp;
        if (cVar != null && cVar.dEA != null) {
            this.ihl = cVar;
            onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
            bk bkVar = this.ihl.dEA;
            PostData aSb = bkVar.aSb();
            if (aSb != null) {
                this.ihm.setPlaceHolder(1);
                if (this.ihl.source == 1) {
                    this.ihm.setData(bkVar, false, true);
                } else {
                    this.ihm.setData(bkVar, false, false);
                }
                this.ihm.setIsRound(true);
                this.ihm.setBorderWidth(2);
                this.ihm.setDrawBorder(true);
                this.ihm.setPageId(this.dIF.getUniqueId());
                if (this.ihl.igw) {
                    this.ihn.setVisibility(0);
                    if (this.ihl.igv == 1) {
                        this.ihn.setImageResource(R.drawable.label_topic_agree_red);
                        this.ihm.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.ihl.igv == 2) {
                        this.ihn.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.ihm.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.ihn.setImageResource(R.drawable.label_topic_eat_black);
                        this.ihm.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.ihn.setVisibility(8);
                }
                if (this.ihl.source == 1) {
                    name_show = aSb.aQx().getName_show();
                    formatTime = aq.getFormatTime(aSb.getTime());
                    aQo = aSb.ddy();
                } else {
                    name_show = bkVar.aQx().getName_show();
                    formatTime = aq.getFormatTime(bkVar.getCreateTime());
                    aQo = bkVar.aQo();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.dXU.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bkVar.aQC())) {
                    this.iho.setText(formatTime);
                } else {
                    this.iho.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bkVar.aQC(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.aUV().a(this.ihr, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(aQo);
                if (aQo > 0) {
                    this.ihq.setVisibility(0);
                    this.ihq.setText(numFormatOverWan);
                } else {
                    this.ihq.setText(this.dIF.getString(R.string.action_comment_default));
                    this.ihq.setVisibility(0);
                }
                if (this.ihl.source == 1) {
                    aSp = aSb.aSp();
                    aSp.objType = 1;
                } else {
                    aSp = bkVar.aSp();
                    aSp.objType = 3;
                }
                aSp.threadId = bkVar.getTid();
                this.ihp.setData(aSp);
                this.ihp.setTopicId(String.valueOf(this.ihl.topicId));
                a(aSb, bkVar);
                a(cVar, bkVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bk bkVar) {
        if (this.ihl.source == 1) {
            this.ihs.setVisibility(0);
            this.ihs.setText(postData.ddw());
            return;
        }
        List<PbContent> aQn = bkVar.aQn();
        if (v.getCount(aQn) > 0) {
            this.ihs.setVisibility(0);
            this.ihs.setText(TbRichTextView.a(getContext(), aQn, false));
            return;
        }
        SpannableString aRt = bkVar.aRt();
        if (aRt != null && !StringUtils.isNull(aRt.toString())) {
            this.ihs.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aRt);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.ihs.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.ihs.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bk bkVar) {
        if (this.ihl.source == 1) {
            this.ihu.setVisibility(0);
            this.iht.setVisibility(8);
            String title = bkVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.ihu.setVisibility(8);
                return;
            }
            this.ihu.setVisibility(0);
            this.ihw.setText(title);
            String str = null;
            if (v.getCount(bkVar.aQH()) != 0 && !v.isEmpty(cVar.dEA.aQH())) {
                Iterator<MediaData> it = cVar.dEA.aQH().iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        str = next.getPicUrl();
                        if (StringUtils.isNull(str)) {
                            str = next.getSmallUrl();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getThumbnails_url();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getSrc_pic();
                        }
                        if (!StringUtils.isNull(str)) {
                            break;
                        }
                    }
                }
            }
            if (StringUtils.isNull(str)) {
                am.setImageResource(this.ihv, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.ihv.setPlaceHolder(1);
            this.ihv.startLoad(str, 10, false);
            return;
        }
        this.ihu.setVisibility(8);
        this.iht.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bk bkVar = cVar.dEA;
        ArrayList<MediaData> aQH = bkVar.aQH();
        if (k.aNQ().isShowImages() && v.getCount(aQH) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aQH.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aQH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.iht.setVisibility(0);
                this.gEm.setFromCDN(this.aha);
                this.gEm.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bkVar);
                        } else {
                            d.this.bbi();
                        }
                    }
                });
                this.gEm.setImageMediaList(linkedList);
                return;
            }
            this.iht.setVisibility(8);
            return;
        }
        this.iht.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gEm != null) {
            this.gEm.setPageUniqueId(bdUniqueId);
        }
    }

    public void bbi() {
        if (this.ihl != null && this.ihl.dEA != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.dIF.getPageActivity()).createFromThreadCfg(this.ihl.dEA, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.ihl.dEA.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.ihl.dEA.aQC());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            m.Dn(this.ihl.dEA.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cgR() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.dIF.getPageActivity()).createNormalCfg(String.valueOf(this.ihl.dEA.getTid()), String.format("%1$s", this.ihl.dEA.aSb().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bk bkVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.aha ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bkVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                }
            }
        }
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bkVar.aQC(), String.valueOf(bkVar.getFid()), bkVar.getTid(), this.aha, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", "other");
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bkVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bkVar.getId();
        historyMessage.threadName = bkVar.getTitle();
        historyMessage.forumName = bkVar.aQC();
        historyMessage.postID = bkVar.aQP();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ihl != null && this.ihl.dEA != null) {
            if (view == this.ihs) {
                if (this.ihl.source == 1) {
                    cgR();
                } else {
                    bbi();
                }
                FG("1");
            }
            if (view == this.ihq || view == this.ihr) {
                if (this.ihl.source == 1) {
                    cgR();
                } else {
                    bbi();
                }
                FG("3");
            } else if (view == this.dXU) {
                cgS();
            } else {
                bbi();
                FG("2");
            }
        }
    }

    private void cgS() {
        MetaData aQx;
        if (this.ihl != null && this.ihl.dEA != null) {
            bk bkVar = this.ihl.dEA;
            if (this.ihl.source == 1 && bkVar.aSb() != null) {
                aQx = bkVar.aSb().aQx();
            } else {
                aQx = bkVar.aQx();
            }
            if (aQx != null && !StringUtils.isNull(aQx.getName_show()) && !StringUtils.isNull(aQx.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(aQx.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aQx.isBigV());
                createNormalConfig.setSourceTid(bkVar.getTid());
                createNormalConfig.setSourceNid(bkVar.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void FG(String str) {
        TiebaStatic.log(new an("c13356").dh("obj_locate", str).dh("tid", this.ihl.dEA.getTid()).s("topic_id", this.ihl.topicId).dh("obj_type", String.valueOf(this.ihl.source)));
    }
}
