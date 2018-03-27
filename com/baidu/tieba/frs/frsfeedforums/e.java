package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> aRI;
    private LikeModel ccX;
    private List<FeedForumData> dNv;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == d.g.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.aRI.getOrignalPage()).checkUpIsLogin()) {
                        e.this.ccX.cc(feedForumData.getForumName(), feedForumData.getForumId());
                        TiebaStatic.log(new ak("c10048").ab(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                    }
                } else if (view.getId() == d.g.frs_like_feed_forum_item) {
                    e.this.aRI.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.aRI.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new ak("c10050").ab(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d dpG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            if (AntiHelper.vR(e.this.ccX.getErrorCode())) {
                AntiHelper.ar(e.this.aRI.getPageActivity(), e.this.ccX.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.ccX.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.ccX.getErrorString());
                }
            } else {
                s sVar = (s) obj;
                sVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, sVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.aRI = tbPageContext;
        this.ccX = new LikeModel(tbPageContext);
        this.ccX.setLoadDataCallBack(this.dpG);
    }

    public void setData(List<FeedForumData> list) {
        this.dNv = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dNv != null) {
            return this.dNv.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dNv != null) {
            return this.dNv.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.dND.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.bUb.setOnClickListener(this.mOnClickListener);
        bVar.dNA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.dNA.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.dNB.setText(String.format(this.aRI.getPageActivity().getString(d.j.attention_post_count), nn(feedForumData.getMemberCount()), nn(feedForumData.getPostNum())));
        bVar.dNC.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.dND.setClickable(true);
            bVar.dND.setOnClickListener(this.mOnClickListener);
            bVar.dND.setEnabled(true);
            bVar.dND.bz(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.bfC != this.mSkinType) {
            aj.s(bVar.bUb, d.f.frs_like_feed_forum_item_bg);
            aj.e(bVar.mTitle, d.C0141d.cp_cont_b, 1);
            aj.e(bVar.dNB, d.C0141d.cp_cont_c, 1);
            aj.e(bVar.dNC, d.C0141d.cp_link_tip_d, 1);
            if (bVar.chO != null) {
                aj.t(bVar.chO, d.C0141d.cp_bg_line_b);
            }
            bVar.bfC = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.dND != null) {
            bVar.dND.bz(true);
            bVar.dND.setEnabled(false);
        }
    }

    private String nn(int i) {
        if (i < 0) {
            return "0";
        }
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i == 10000) {
            return "1W";
        }
        if (i / 10000.0f <= 9999.9f) {
            return String.format("%.1fW", Float.valueOf(i / 10000.0f));
        }
        return "9999.9+W";
    }

    public void a(List<FeedForumData> list, s sVar) {
        if (list != null && list.size() > 0 && sVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(sVar.getFid())) {
                    feedForumData.setIsLike(sVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
