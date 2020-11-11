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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
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
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean akk;
    private TbPageContext eIc;
    private TextView ewx;
    private ConstrainImageGroup hYg;
    private TbImageView jKA;
    private TextView jKB;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c jKq;
    private ClickableHeaderImageView jKr;
    private ImageView jKs;
    private TextView jKt;
    private AgreeView jKu;
    private TextView jKv;
    private ImageView jKw;
    private TbRichTextView jKx;
    private RelativeLayout jKy;
    private View jKz;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.akk = true;
        this.mSkinType = 3;
        this.eIc = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.jKr = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.jKs = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.ewx = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.jKt = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.jKx = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.jKx.setClickable(true);
        this.jKx.setTextEllipsize(TextUtils.TruncateAt.END);
        this.jKx.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jKx.setLayoutStrategy(aVar);
        this.jKy = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.hYg = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.hYg.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.y(1.0d);
        this.hYg.setImageProcessor(aVar2);
        this.jKu = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.jKu.bsc();
        this.jKv = (TextView) view.findViewById(R.id.topic_comment_number);
        this.jKw = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.jKz = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.jKA = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.jKA.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.jKA.setConrers(5);
        this.jKA.setDrawCorner(true);
        this.jKB = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.ewx.setOnClickListener(this);
        this.jKv.setOnClickListener(this);
        this.jKw.setOnClickListener(this);
        this.jKx.setOnClickListener(this);
        this.jKz.setOnClickListener(this);
        this.jKB.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hYg != null) {
            this.hYg.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hYg != null) {
            this.hYg.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.jKq != null) {
            this.mSkinType = i;
            this.jKr.setIsNight(this.mSkinType == 1);
            if (this.jKq.jJA) {
                if (this.jKq.jJz == 1) {
                    ap.setImageResource(this.jKs, R.drawable.label_topic_agree_red);
                    this.jKr.setBorderColor(this.eIc.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.jKq.jJz == 2) {
                    ap.setImageResource(this.jKs, R.drawable.label_topic_disagree_blue);
                    this.jKr.setBorderColor(this.eIc.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    ap.setImageResource(this.jKs, R.drawable.label_topic_eat_black);
                    this.jKr.setBorderColor(this.eIc.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            ap.setViewTextColor(this.ewx, R.color.cp_cont_b);
            ap.setViewTextColor(this.jKt, R.color.cp_cont_d);
            ap.setViewTextColor(this.jKv, R.color.cp_cont_j);
            if (this.jKw != null) {
                SvgManager.brn().a(this.jKw, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.jKu.onChangeSkinType(i);
            this.jKx.setTextColor(ap.getColor(R.color.cp_cont_b));
            ap.c(this.jKz, l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            ap.setViewTextColor(this.jKB, R.color.cp_cont_d);
            this.hYg.onChangeSkinType();
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_e);
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
        int bmr;
        AgreeData bor;
        if (cVar != null && cVar.exA != null) {
            this.jKq = cVar;
            onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
            bw bwVar = this.jKq.exA;
            PostData bod = bwVar.bod();
            if (bod != null) {
                this.jKr.setPlaceHolder(1);
                if (this.jKq.source == 1) {
                    this.jKr.setData(bwVar, false, true);
                } else {
                    this.jKr.setData(bwVar, false, false);
                }
                this.jKr.setIsRound(true);
                this.jKr.setBorderWidth(2);
                this.jKr.setDrawBorder(true);
                this.jKr.setPageId(this.eIc.getUniqueId());
                if (this.jKq.jJA) {
                    this.jKs.setVisibility(0);
                    if (this.jKq.jJz == 1) {
                        this.jKs.setImageResource(R.drawable.label_topic_agree_red);
                        this.jKr.setBorderColor(this.eIc.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.jKq.jJz == 2) {
                        this.jKs.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.jKr.setBorderColor(this.eIc.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.jKs.setImageResource(R.drawable.label_topic_eat_black);
                        this.jKr.setBorderColor(this.eIc.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.jKs.setVisibility(8);
                }
                if (this.jKq.source == 1) {
                    name_show = bod.bmA().getName_show();
                    formatTime = at.getFormatTime(bod.getTime());
                    bmr = bod.dKd();
                } else {
                    name_show = bwVar.bmA().getName_show();
                    formatTime = at.getFormatTime(bwVar.getCreateTime());
                    bmr = bwVar.bmr();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.ewx.setText(at.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bwVar.bmE())) {
                    this.jKt.setText(formatTime);
                } else {
                    this.jKt.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), at.cutChineseAndEnglishWithSuffix(bwVar.bmE(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.brn().a(this.jKw, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = at.numFormatOverWan(bmr);
                if (bmr > 0) {
                    this.jKv.setVisibility(0);
                    this.jKv.setText(numFormatOverWan);
                } else {
                    this.jKv.setText(this.eIc.getString(R.string.action_comment_default));
                    this.jKv.setVisibility(0);
                }
                if (this.jKq.source == 1) {
                    bor = bod.bor();
                    bor.objType = 1;
                } else {
                    bor = bwVar.bor();
                    bor.objType = 3;
                }
                bor.threadId = bwVar.getTid();
                this.jKu.setData(bor);
                this.jKu.setTopicId(String.valueOf(this.jKq.topicId));
                a(bod, bwVar);
                a(cVar, bwVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bw bwVar) {
        if (this.jKq.source == 1) {
            this.jKx.setVisibility(0);
            this.jKx.setText(postData.dKb());
            return;
        }
        List<PbContent> bmq = bwVar.bmq();
        if (y.getCount(bmq) > 0) {
            this.jKx.setVisibility(0);
            this.jKx.setText(TbRichTextView.a(getContext(), bmq, false));
            return;
        }
        SpannableString bnv = bwVar.bnv();
        if (bnv != null && !StringUtils.isNull(bnv.toString())) {
            this.jKx.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", bnv);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.jKx.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.jKx.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bw bwVar) {
        if (this.jKq.source == 1) {
            this.jKz.setVisibility(0);
            this.jKy.setVisibility(8);
            String title = bwVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.jKz.setVisibility(8);
                return;
            }
            this.jKz.setVisibility(0);
            this.jKB.setText(title);
            String str = null;
            if (y.getCount(bwVar.bmJ()) != 0 && !y.isEmpty(cVar.exA.bmJ())) {
                Iterator<MediaData> it = cVar.exA.bmJ().iterator();
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
                ap.setImageResource(this.jKA, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.jKA.setPlaceHolder(1);
            this.jKA.startLoad(str, 10, false);
            return;
        }
        this.jKz.setVisibility(8);
        this.jKy.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bw bwVar = cVar.exA;
        ArrayList<MediaData> bmJ = bwVar.bmJ();
        if (k.bjH().isShowImages() && y.getCount(bmJ) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bmJ.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bmJ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.jKy.setVisibility(0);
                this.hYg.setFromCDN(this.akk);
                this.hYg.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bwVar);
                        } else {
                            d.this.bxB();
                        }
                    }
                });
                this.hYg.setImageMediaList(linkedList);
                return;
            }
            this.jKy.setVisibility(8);
            return;
        }
        this.jKy.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hYg != null) {
            this.hYg.setPageUniqueId(bdUniqueId);
        }
    }

    public void bxB() {
        if (this.jKq != null && this.jKq.exA != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eIc.getPageActivity()).createFromThreadCfg(this.jKq.exA, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.jKq.exA.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.jKq.exA.bmE());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            n.IZ(this.jKq.exA.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cMf() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.eIc.getPageActivity()).createNormalCfg(String.valueOf(this.jKq.exA.getTid()), String.format("%1$s", this.jKq.exA.bod().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.akk ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
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
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.x(arrayList).nP(i).AE(bwVar.bmE()).AF(String.valueOf(bwVar.getFid())).AG(bwVar.getTid()).ix(this.akk).AH(arrayList.size() > 0 ? arrayList.get(0) : "").iy(true).a(concurrentHashMap).iz(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dU.getIntent().putExtra("from", "index");
        } else {
            dU.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.bmE();
        historyMessage.postID = bwVar.bmR();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jKq != null && this.jKq.exA != null) {
            if (view == this.jKx) {
                if (this.jKq.source == 1) {
                    cMf();
                } else {
                    bxB();
                }
                LT("1");
            }
            if (view == this.jKv || view == this.jKw) {
                if (this.jKq.source == 1) {
                    cMf();
                } else {
                    bxB();
                }
                LT("3");
            } else if (view == this.ewx) {
                cMg();
            } else {
                bxB();
                LT("2");
            }
        }
    }

    private void cMg() {
        MetaData bmA;
        if (this.jKq != null && this.jKq.exA != null) {
            bw bwVar = this.jKq.exA;
            if (this.jKq.source == 1 && bwVar.bod() != null) {
                bmA = bwVar.bod().bmA();
            } else {
                bmA = bwVar.bmA();
            }
            if (bmA != null && !StringUtils.isNull(bmA.getName_show()) && !StringUtils.isNull(bmA.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(bmA.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bmA.isBigV());
                createNormalConfig.setSourceTid(bwVar.getTid());
                createNormalConfig.setSourceNid(bwVar.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void LT(String str) {
        TiebaStatic.log(new aq("c13356").dR("obj_locate", str).dR("tid", this.jKq.exA.getTid()).w("topic_id", this.jKq.topicId).dR("obj_type", String.valueOf(this.jKq.source)));
    }
}
