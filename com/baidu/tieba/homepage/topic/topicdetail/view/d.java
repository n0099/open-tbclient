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
    private ConstrainImageGroup gEx;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c ihY;
    private ClickableHeaderImageView ihZ;
    private ImageView iia;
    private TextView iib;
    private AgreeView iic;
    private TextView iid;
    private ImageView iie;
    private TbRichTextView iif;
    private RelativeLayout iig;
    private View iih;
    private TbImageView iii;
    private TextView iij;
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
        this.ihZ = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.iia = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.dXU = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.iib = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.iif = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.iif.setClickable(true);
        this.iif.setTextEllipsize(TextUtils.TruncateAt.END);
        this.iif.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iif.setLayoutStrategy(aVar);
        this.iig = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.gEx = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.gEx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.o(1.0d);
        this.gEx.setImageProcessor(aVar2);
        this.iic = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.iic.aVO();
        this.iid = (TextView) view.findViewById(R.id.topic_comment_number);
        this.iie = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.iih = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.iii = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.iii.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.iii.setConrers(5);
        this.iii.setDrawCorner(true);
        this.iij = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.dXU.setOnClickListener(this);
        this.iid.setOnClickListener(this);
        this.iie.setOnClickListener(this);
        this.iif.setOnClickListener(this);
        this.iih.setOnClickListener(this);
        this.iij.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gEx != null) {
            this.gEx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gEx != null) {
            this.gEx.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.ihY != null) {
            this.mSkinType = i;
            this.ihZ.setIsNight(this.mSkinType == 1);
            if (this.ihY.ihj) {
                if (this.ihY.ihi == 1) {
                    am.setImageResource(this.iia, R.drawable.label_topic_agree_red);
                    this.ihZ.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.ihY.ihi == 2) {
                    am.setImageResource(this.iia, R.drawable.label_topic_disagree_blue);
                    this.ihZ.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.iia, R.drawable.label_topic_eat_black);
                    this.ihZ.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.dXU, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.iib, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.iid, (int) R.color.cp_cont_j);
            if (this.iie != null) {
                SvgManager.aUW().a(this.iie, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.iic.onChangeSkinType(i);
            this.iif.setTextColor(am.getColor(R.color.cp_cont_b));
            am.c(this.iih, l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.iij, (int) R.color.cp_cont_d);
            this.gEx.onChangeSkinType();
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
            this.ihY = cVar;
            onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
            bk bkVar = this.ihY.dEA;
            PostData aSb = bkVar.aSb();
            if (aSb != null) {
                this.ihZ.setPlaceHolder(1);
                if (this.ihY.source == 1) {
                    this.ihZ.setData(bkVar, false, true);
                } else {
                    this.ihZ.setData(bkVar, false, false);
                }
                this.ihZ.setIsRound(true);
                this.ihZ.setBorderWidth(2);
                this.ihZ.setDrawBorder(true);
                this.ihZ.setPageId(this.dIF.getUniqueId());
                if (this.ihY.ihj) {
                    this.iia.setVisibility(0);
                    if (this.ihY.ihi == 1) {
                        this.iia.setImageResource(R.drawable.label_topic_agree_red);
                        this.ihZ.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.ihY.ihi == 2) {
                        this.iia.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.ihZ.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.iia.setImageResource(R.drawable.label_topic_eat_black);
                        this.ihZ.setBorderColor(this.dIF.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.iia.setVisibility(8);
                }
                if (this.ihY.source == 1) {
                    name_show = aSb.aQx().getName_show();
                    formatTime = aq.getFormatTime(aSb.getTime());
                    aQo = aSb.ddN();
                } else {
                    name_show = bkVar.aQx().getName_show();
                    formatTime = aq.getFormatTime(bkVar.getCreateTime());
                    aQo = bkVar.aQo();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.dXU.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bkVar.aQC())) {
                    this.iib.setText(formatTime);
                } else {
                    this.iib.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bkVar.aQC(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.aUW().a(this.iie, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(aQo);
                if (aQo > 0) {
                    this.iid.setVisibility(0);
                    this.iid.setText(numFormatOverWan);
                } else {
                    this.iid.setText(this.dIF.getString(R.string.action_comment_default));
                    this.iid.setVisibility(0);
                }
                if (this.ihY.source == 1) {
                    aSp = aSb.aSp();
                    aSp.objType = 1;
                } else {
                    aSp = bkVar.aSp();
                    aSp.objType = 3;
                }
                aSp.threadId = bkVar.getTid();
                this.iic.setData(aSp);
                this.iic.setTopicId(String.valueOf(this.ihY.topicId));
                a(aSb, bkVar);
                a(cVar, bkVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bk bkVar) {
        if (this.ihY.source == 1) {
            this.iif.setVisibility(0);
            this.iif.setText(postData.ddL());
            return;
        }
        List<PbContent> aQn = bkVar.aQn();
        if (v.getCount(aQn) > 0) {
            this.iif.setVisibility(0);
            this.iif.setText(TbRichTextView.a(getContext(), aQn, false));
            return;
        }
        SpannableString aRt = bkVar.aRt();
        if (aRt != null && !StringUtils.isNull(aRt.toString())) {
            this.iif.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aRt);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.iif.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.iif.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bk bkVar) {
        if (this.ihY.source == 1) {
            this.iih.setVisibility(0);
            this.iig.setVisibility(8);
            String title = bkVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.iih.setVisibility(8);
                return;
            }
            this.iih.setVisibility(0);
            this.iij.setText(title);
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
                am.setImageResource(this.iii, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.iii.setPlaceHolder(1);
            this.iii.startLoad(str, 10, false);
            return;
        }
        this.iih.setVisibility(8);
        this.iig.setVisibility(0);
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
                this.iig.setVisibility(0);
                this.gEx.setFromCDN(this.aha);
                this.gEx.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bkVar);
                        } else {
                            d.this.bbj();
                        }
                    }
                });
                this.gEx.setImageMediaList(linkedList);
                return;
            }
            this.iig.setVisibility(8);
            return;
        }
        this.iig.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gEx != null) {
            this.gEx.setPageUniqueId(bdUniqueId);
        }
    }

    public void bbj() {
        if (this.ihY != null && this.ihY.dEA != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.dIF.getPageActivity()).createFromThreadCfg(this.ihY.dEA, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.ihY.dEA.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.ihY.dEA.aQC());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            m.Dn(this.ihY.dEA.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cha() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.dIF.getPageActivity()).createNormalCfg(String.valueOf(this.ihY.dEA.getTid()), String.format("%1$s", this.ihY.dEA.aSb().getId()) + "", 1, "mention");
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
        if (this.ihY != null && this.ihY.dEA != null) {
            if (view == this.iif) {
                if (this.ihY.source == 1) {
                    cha();
                } else {
                    bbj();
                }
                FG("1");
            }
            if (view == this.iid || view == this.iie) {
                if (this.ihY.source == 1) {
                    cha();
                } else {
                    bbj();
                }
                FG("3");
            } else if (view == this.dXU) {
                chb();
            } else {
                bbj();
                FG("2");
            }
        }
    }

    private void chb() {
        MetaData aQx;
        if (this.ihY != null && this.ihY.dEA != null) {
            bk bkVar = this.ihY.dEA;
            if (this.ihY.source == 1 && bkVar.aSb() != null) {
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
        TiebaStatic.log(new an("c13356").dh("obj_locate", str).dh("tid", this.ihY.dEA.getTid()).s("topic_id", this.ihY.topicId).dh("obj_type", String.valueOf(this.ihY.source)));
    }
}
