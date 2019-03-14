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
    private boolean ZP;
    private int bSK;
    private TextView bTY;
    private ConstrainImageGroup ein;
    private View fPA;
    private TbImageView fPB;
    private TextView fPC;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c fPr;
    private ClickableHeaderImageView fPs;
    private ImageView fPt;
    private TextView fPu;
    private AgreeAloneView fPv;
    private TextView fPw;
    private ImageView fPx;
    private TbRichTextView fPy;
    private RelativeLayout fPz;
    private View mBottomLine;
    private TbPageContext mContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ZP = true;
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.bSK = d.f.selector_topic_detail_comment_icon;
        this.fPs = (ClickableHeaderImageView) view.findViewById(d.g.card_topic_detail_discuss_thread_user_header);
        this.fPt = (ImageView) view.findViewById(d.g.card_topic_detail_thread_opinion_img);
        this.bTY = (TextView) view.findViewById(d.g.card_topic_detail_discuss_thread_user_name);
        this.fPu = (TextView) view.findViewById(d.g.card_topic_detail_discuss_thread_forum_name);
        this.fPy = (TbRichTextView) view.findViewById(d.g.card_topic_detail_discuss_title);
        this.fPy.setClickable(true);
        this.fPy.getLayoutStrategy().setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds20), 1.0f);
        this.fPy.setTextEllipsize(TextUtils.TruncateAt.END);
        this.fPy.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.h(getContext(), d.e.tbds44));
        aVar.setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds7), 1.0f);
        this.fPy.setLayoutStrategy(aVar);
        this.fPz = (RelativeLayout) view.findViewById(d.g.topic_detail_img_container);
        this.ein = (ConstrainImageGroup) view.findViewById(d.g.card_topic_detail_discuss_thread_img_layout);
        this.ein.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.ein.setImageProcessor(aVar2);
        this.fPv = (AgreeAloneView) view.findViewById(d.g.card_topic_detail_discuss_argee_view);
        this.fPw = (TextView) view.findViewById(d.g.topic_comment_number);
        this.fPx = (ImageView) view.findViewById(d.g.topic_comment_pic);
        this.fPA = view.findViewById(d.g.card_topic_detail_discuss_original_thread_layout);
        this.fPB = (TbImageView) view.findViewById(d.g.card_topic_discuss_original_thread_pic);
        this.fPB.setRadius(l.h(getContext(), d.e.tbds6));
        this.fPB.setConrers(5);
        this.fPB.setDrawCorner(true);
        this.fPC = (TextView) view.findViewById(d.g.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(d.g.card_topic_detail_discuss_line_layout);
        this.fPw.setOnClickListener(this);
        this.fPx.setOnClickListener(this);
        this.fPy.setOnClickListener(this);
        this.fPA.setOnClickListener(this);
        this.fPC.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.ein != null) {
            this.ein.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.ein != null) {
            this.ein.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.ein != null) {
            this.ein.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.fPr != null) {
            this.mSkinType = i;
            this.fPs.setIsNight(this.mSkinType == 1);
            if (this.fPr.fOz) {
                if (this.fPr.fOx == 1) {
                    al.c(this.fPt, d.f.label_topic_agree_red);
                    this.fPs.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_cont_h));
                } else if (this.fPr.fOx == 2) {
                    al.c(this.fPt, d.f.label_topic_disagree_blue);
                    this.fPs.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_link_tip_a));
                } else {
                    al.c(this.fPt, d.f.label_topic_eat_black);
                    this.fPs.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_cont_f));
                }
            }
            al.j(this.bTY, d.C0277d.cp_cont_b);
            al.j(this.fPu, d.C0277d.cp_cont_d);
            al.j(this.fPw, d.f.selector_topic_detail_comment_text_color);
            if (this.fPx != null && this.bSK > 0) {
                this.fPx.setImageDrawable(al.getDrawable(this.bSK));
            }
            this.fPv.onChangeSkinType(i);
            this.fPy.setTextColor(al.getColor(d.C0277d.cp_cont_b));
            al.k(this.fPA, d.f.topic_original_bg_corner);
            al.j(this.fPC, d.C0277d.cp_cont_d);
            this.ein.onChangeSkinType();
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
        int YI;
        AgreeData aaH;
        if (cVar != null && cVar.threadData != null) {
            this.fPr = cVar;
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            bg bgVar = this.fPr.threadData;
            PostData aap = bgVar.aap();
            if (aap != null) {
                if (this.fPr.fOy == 1) {
                    this.fPs.setData(bgVar, false, true);
                } else {
                    this.fPs.setData(bgVar, false, false);
                }
                this.fPs.setDefaultResource(d.f.icon_default_avatar100);
                this.fPs.setDefaultBgResource(d.C0277d.cp_bg_line_e);
                this.fPs.setIsRound(true);
                this.fPs.setBorderWidth(2);
                this.fPs.setDrawBorder(true);
                this.fPs.setPageId(this.mContext.getUniqueId());
                if (this.fPr.fOz) {
                    this.fPt.setVisibility(0);
                    if (this.fPr.fOx == 1) {
                        this.fPt.setImageResource(d.f.label_topic_agree_red);
                        this.fPs.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_cont_h));
                    } else if (this.fPr.fOx == 2) {
                        this.fPt.setImageResource(d.f.label_topic_disagree_blue);
                        this.fPs.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_link_tip_a));
                    } else {
                        this.fPt.setImageResource(d.f.label_topic_eat_black);
                        this.fPs.setBorderColor(this.mContext.getPageActivity().getResources().getColor(d.C0277d.cp_cont_f));
                    }
                } else {
                    this.fPt.setVisibility(8);
                }
                if (this.fPr.fOy == 1) {
                    name_show = aap.YR().getName_show();
                    ao = ap.ao(aap.getTime());
                    YI = aap.cex();
                } else {
                    name_show = bgVar.YR().getName_show();
                    ao = ap.ao(bgVar.getCreateTime());
                    YI = bgVar.YI();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.bTY.setText(ap.g(name_show, 14, "..."));
                }
                if (StringUtils.isNull(bgVar.YW())) {
                    this.fPu.setText(ao);
                } else {
                    this.fPu.setText(String.format(getContext().getString(d.j.daily_topic_discuss_forum_name), ap.g(bgVar.YW(), 10, "..."), ao));
                }
                this.fPx.setImageDrawable(al.getDrawable(this.bSK));
                String az = ap.az(YI);
                if (YI > 0) {
                    this.fPw.setVisibility(0);
                    this.fPw.setText(az);
                } else {
                    this.fPw.setText(this.mContext.getString(d.j.action_comment_default));
                    this.fPw.setVisibility(0);
                }
                if (this.fPr.fOy == 1) {
                    aaH = aap.aaH();
                    aaH.objType = 1;
                } else {
                    aaH = bgVar.aaH();
                    aaH.objType = 3;
                }
                aaH.threadId = bgVar.getTid();
                this.fPv.setData(aaH);
                this.fPv.setTopicId(String.valueOf(this.fPr.topicId));
                if (this.fPr.fOy == 1) {
                    this.fPy.setVisibility(0);
                    this.fPy.setText(aap.cev());
                } else {
                    this.fPy.setVisibility(0);
                    int size = bgVar.YH().size();
                    if (StringUtils.isNull(bgVar.aas().toString()) && size <= 0) {
                        this.fPy.setVisibility(8);
                    } else if (size > 0) {
                        TbRichText a = TbRichTextView.a(getContext(), bgVar.YH(), false);
                        if (a != null) {
                            this.fPy.setText(a);
                        }
                    } else if (!StringUtils.isNull(bgVar.aas().toString())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "0");
                            jSONObject.put("text", bgVar.aas().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        this.fPy.setText(TbRichTextView.a(getContext(), jSONArray, false));
                    } else {
                        this.fPy.setVisibility(8);
                    }
                }
                if (this.fPr.fOy == 1) {
                    this.fPA.setVisibility(0);
                    this.fPz.setVisibility(8);
                    ArrayList<MediaData> Zb = bgVar.Zb();
                    String str = null;
                    String title = bgVar.getTitle();
                    if (v.S(Zb) != 0 && !v.T(cVar.threadData.Zb())) {
                        Iterator<MediaData> it = cVar.threadData.Zb().iterator();
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
                        this.fPA.setVisibility(8);
                    } else {
                        this.fPA.setVisibility(0);
                        this.fPC.setText(title);
                        if (StringUtils.isNull(str)) {
                            al.c(this.fPB, d.f.pic_frs_topic_shareinone);
                        } else {
                            this.fPB.startLoad(str, 10, false);
                        }
                    }
                } else {
                    this.fPA.setVisibility(8);
                    this.fPz.setVisibility(0);
                    b(cVar);
                }
                setPageUniqueId(getTag());
            }
        }
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bg bgVar = cVar.threadData;
        ArrayList<MediaData> Zb = bgVar.Zb();
        if (i.Wy().WC() && v.S(Zb) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < Zb.size(); i++) {
                MediaData mediaData = (MediaData) v.c(Zb, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.S(linkedList) > 0) {
                this.fPz.setVisibility(0);
                this.ein.setFromCDN(this.ZP);
                this.ein.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bgVar);
                        } else {
                            d.this.ajX();
                        }
                    }
                });
                this.ein.setImageMediaList(linkedList);
                return;
            }
            this.fPz.setVisibility(8);
            return;
        }
        this.fPz.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ein != null) {
            this.ein.setPageUniqueId(bdUniqueId);
        }
    }

    public void ajX() {
        if (this.fPr != null && this.fPr.threadData != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.fPr.threadData, null, "none", 18003, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.fPr.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.fPr.threadData.YW());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            n.tA(this.fPr.threadData.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void bnp() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext.getPageActivity()).createNormalCfg(String.valueOf(this.fPr.threadData.getTid()), String.format("%1$s", this.fPr.threadData.aap().getId()) + "", 1, "mention");
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
                    imageUrlData.urlType = this.ZP ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.YW(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.ZP, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bgVar.YW();
        historyMessage.postID = bgVar.Zh();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fPr != null && this.fPr.threadData != null) {
            if (view == this.fPy) {
                if (this.fPr.fOy == 1) {
                    bnp();
                } else {
                    ajX();
                }
                wk("1");
            }
            if (view == this.fPw || view == this.fPx) {
                if (this.fPr.fOy == 1) {
                    bnp();
                } else {
                    ajX();
                }
                wk("3");
                return;
            }
            ajX();
            wk("2");
        }
    }

    private void wk(String str) {
        TiebaStatic.log(new am("c13356").bJ("obj_locate", str).bJ("tid", this.fPr.threadData.getTid()).k("topic_id", this.fPr.topicId).bJ("obj_type", String.valueOf(this.fPr.fOy)));
    }
}
