package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Rect;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AgreeAloneView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
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
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean ZR;
    private int bSN;
    private TextView bUb;
    private ConstrainImageGroup eia;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c fPf;
    private ClickableHeaderImageView fPg;
    private ImageView fPh;
    private TextView fPi;
    private AgreeAloneView fPj;
    private TextView fPk;
    private ImageView fPl;
    private TbRichTextView fPm;
    private RelativeLayout fPn;
    private View fPo;
    private TbImageView fPp;
    private TextView fPq;
    private View mBottomLine;
    private TbPageContext mContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ZR = true;
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.bSN = d.f.selector_topic_detail_comment_icon;
        this.fPg = (ClickableHeaderImageView) view.findViewById(d.g.card_topic_detail_discuss_thread_user_header);
        this.fPh = (ImageView) view.findViewById(d.g.card_topic_detail_thread_opinion_img);
        this.bUb = (TextView) view.findViewById(d.g.card_topic_detail_discuss_thread_user_name);
        this.fPi = (TextView) view.findViewById(d.g.card_topic_detail_discuss_thread_forum_name);
        this.fPm = (TbRichTextView) view.findViewById(d.g.card_topic_detail_discuss_title);
        this.fPm.setClickable(true);
        this.fPm.getLayoutStrategy().setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds20), 1.0f);
        this.fPm.setTextEllipsize(TextUtils.TruncateAt.END);
        this.fPm.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.h(getContext(), d.e.tbds44));
        aVar.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds7), 1.0f);
        this.fPm.setLayoutStrategy(aVar);
        this.fPn = (RelativeLayout) view.findViewById(d.g.topic_detail_img_container);
        this.eia = (ConstrainImageGroup) view.findViewById(d.g.card_topic_detail_discuss_thread_img_layout);
        this.eia.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.eia.setImageProcessor(aVar2);
        this.fPj = (AgreeAloneView) view.findViewById(d.g.card_topic_detail_discuss_argee_view);
        this.fPk = (TextView) view.findViewById(d.g.topic_comment_number);
        this.fPl = (ImageView) view.findViewById(d.g.topic_comment_pic);
        this.fPo = view.findViewById(d.g.card_topic_detail_discuss_original_thread_layout);
        this.fPp = (TbImageView) view.findViewById(d.g.card_topic_discuss_original_thread_pic);
        this.fPp.setRadius(l.h(getContext(), d.e.tbds6));
        this.fPp.setConrers(5);
        this.fPp.setDrawCorner(true);
        this.fPq = (TextView) view.findViewById(d.g.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(d.g.card_topic_detail_discuss_line_layout);
        this.fPk.setOnClickListener(this);
        this.fPl.setOnClickListener(this);
        this.fPm.setOnClickListener(this);
        this.fPo.setOnClickListener(this);
        this.fPq.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eia != null) {
            this.eia.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eia != null) {
            this.eia.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eia != null) {
            this.eia.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.fPf != null) {
            this.mSkinType = i;
            this.fPg.setIsNight(this.mSkinType == 1);
            if (this.fPf.fOn) {
                if (this.fPf.fOl == 1) {
                    al.c(this.fPh, d.f.label_topic_agree_red);
                    this.fPg.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_cont_h));
                } else if (this.fPf.fOl == 2) {
                    al.c(this.fPh, d.f.label_topic_disagree_blue);
                    this.fPg.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_link_tip_a));
                } else {
                    al.c(this.fPh, d.f.label_topic_eat_black);
                    this.fPg.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_cont_f));
                }
            }
            al.j(this.bUb, d.C0277d.cp_cont_b);
            al.j(this.fPi, d.C0277d.cp_cont_d);
            al.j(this.fPk, d.f.selector_topic_detail_comment_text_color);
            if (this.fPl != null && this.bSN > 0) {
                this.fPl.setImageDrawable(al.getDrawable(this.bSN));
            }
            this.fPj.onChangeSkinType(i);
            this.fPm.setTextColor(al.getColor(d.C0277d.cp_cont_b));
            al.k(this.fPo, d.f.topic_original_bg_corner);
            al.j(this.fPq, d.C0277d.cp_cont_d);
            this.eia.onChangeSkinType();
            al.l(this.mBottomLine, d.C0277d.cp_bg_line_c);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        String name_show;
        String ao;
        int YF;
        AgreeData aaE;
        if (cVar != null && cVar.threadData != null) {
            this.fPf = cVar;
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            bg bgVar = this.fPf.threadData;
            PostData aam = bgVar.aam();
            if (aam != null) {
                if (this.fPf.fOm == 1) {
                    this.fPg.setData(bgVar, false, true);
                } else {
                    this.fPg.setData(bgVar, false, false);
                }
                this.fPg.setDefaultResource(d.f.icon_default_avatar100);
                this.fPg.setDefaultBgResource(d.C0277d.cp_bg_line_e);
                this.fPg.setIsRound(true);
                this.fPg.setBorderWidth(2);
                this.fPg.setDrawBorder(true);
                this.fPg.setPageId(this.mContext.getUniqueId());
                if (this.fPf.fOn) {
                    this.fPh.setVisibility(0);
                    if (this.fPf.fOl == 1) {
                        this.fPh.setImageResource(d.f.label_topic_agree_red);
                        this.fPg.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_cont_h));
                    } else if (this.fPf.fOl == 2) {
                        this.fPh.setImageResource(d.f.label_topic_disagree_blue);
                        this.fPg.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_link_tip_a));
                    } else {
                        this.fPh.setImageResource(d.f.label_topic_eat_black);
                        this.fPg.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_cont_f));
                    }
                } else {
                    this.fPh.setVisibility(8);
                }
                if (this.fPf.fOm == 1) {
                    name_show = aam.YO().getName_show();
                    ao = ap.ao(aam.getTime());
                    YF = aam.cet();
                } else {
                    name_show = bgVar.YO().getName_show();
                    ao = ap.ao(bgVar.getCreateTime());
                    YF = bgVar.YF();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.bUb.setText(ap.g(name_show, 14, "..."));
                }
                if (StringUtils.isNull(bgVar.YT())) {
                    this.fPi.setText(ao);
                } else {
                    this.fPi.setText(String.format(getContext().getString(d.j.daily_topic_discuss_forum_name), ap.g(bgVar.YT(), 10, "..."), ao));
                }
                this.fPl.setImageDrawable(al.getDrawable(this.bSN));
                String az = ap.az(YF);
                if (YF > 0) {
                    this.fPk.setVisibility(0);
                    this.fPk.setText(az);
                } else {
                    this.fPk.setText(this.mContext.getString(d.j.action_comment_default));
                    this.fPk.setVisibility(0);
                }
                if (this.fPf.fOm == 1) {
                    aaE = aam.aaE();
                    aaE.objType = 1;
                } else {
                    aaE = bgVar.aaE();
                    aaE.objType = 3;
                }
                aaE.threadId = bgVar.getTid();
                this.fPj.setData(aaE);
                this.fPj.setTopicId(String.valueOf(this.fPf.topicId));
                if (this.fPf.fOm == 1) {
                    this.fPm.setVisibility(0);
                    this.fPm.setText(aam.cer());
                } else {
                    this.fPm.setVisibility(0);
                    int size = bgVar.YE().size();
                    if (StringUtils.isNull(bgVar.aap().toString()) && size <= 0) {
                        this.fPm.setVisibility(8);
                    } else if (size > 0) {
                        TbRichText a = TbRichTextView.a(getContext(), bgVar.YE(), false);
                        if (a != null) {
                            this.fPm.setText(a);
                        }
                    } else if (!StringUtils.isNull(bgVar.aap().toString())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "0");
                            jSONObject.put("text", bgVar.aap().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        this.fPm.setText(TbRichTextView.a(getContext(), jSONArray, false));
                    } else {
                        this.fPm.setVisibility(8);
                    }
                }
                if (this.fPf.fOm == 1) {
                    this.fPo.setVisibility(0);
                    this.fPn.setVisibility(8);
                    ArrayList<MediaData> YY = bgVar.YY();
                    String str = null;
                    String title = bgVar.getTitle();
                    if (v.S(YY) != 0 && !v.T(cVar.threadData.YY())) {
                        Iterator<MediaData> it = cVar.threadData.YY().iterator();
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
                    if (StringUtils.isNull(title)) {
                        this.fPo.setVisibility(8);
                    } else {
                        this.fPo.setVisibility(0);
                        this.fPq.setText(title);
                        if (StringUtils.isNull(str)) {
                            al.c(this.fPp, d.f.pic_frs_topic_shareinone);
                        } else {
                            this.fPp.startLoad(str, 10, false);
                        }
                    }
                } else {
                    this.fPo.setVisibility(8);
                    this.fPn.setVisibility(0);
                    b(cVar);
                }
                setPageUniqueId(getTag());
            }
        }
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bg bgVar = cVar.threadData;
        ArrayList<MediaData> YY = bgVar.YY();
        if (i.Wv().Wz() && v.S(YY) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < YY.size(); i++) {
                MediaData mediaData = (MediaData) v.c(YY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.S(linkedList) > 0) {
                this.fPn.setVisibility(0);
                this.eia.setFromCDN(this.ZR);
                this.eia.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bgVar);
                        } else {
                            d.this.ajU();
                        }
                    }
                });
                this.eia.setImageMediaList(linkedList);
                return;
            }
            this.fPn.setVisibility(8);
            return;
        }
        this.fPn.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eia != null) {
            this.eia.setPageUniqueId(bdUniqueId);
        }
    }

    public void ajU() {
        if (this.fPf != null && this.fPf.threadData != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.fPf.threadData, null, "none", 18003, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.fPf.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.fPf.threadData.YT());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            n.tz(this.fPf.threadData.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void bnm() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext.getPageActivity()).createNormalCfg(String.valueOf(this.fPf.threadData.getTid()), String.format("%1$s", this.fPf.threadData.aam().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
            l.showToast(this.mTbPageContext.getPageActivity(), d.j.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.ZR ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.d(bgVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YT(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZR, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bgVar.getId();
        historyMessage.threadName = bgVar.getTitle();
        historyMessage.forumName = bgVar.YT();
        historyMessage.postID = bgVar.Ze();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fPf != null && this.fPf.threadData != null) {
            if (view == this.fPm) {
                if (this.fPf.fOm == 1) {
                    bnm();
                } else {
                    ajU();
                }
                wj("1");
            }
            if (view == this.fPk || view == this.fPl) {
                if (this.fPf.fOm == 1) {
                    bnm();
                } else {
                    ajU();
                }
                wj("3");
                return;
            }
            ajU();
            wj("2");
        }
    }

    private void wj(String str) {
        TiebaStatic.log(new am("c13356").bJ("obj_locate", str).bJ("tid", this.fPf.threadData.getTid()).k("topic_id", this.fPf.topicId).bJ("obj_type", String.valueOf(this.fPf.fOm)));
    }
}
