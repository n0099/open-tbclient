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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> cVg;
    private LikeModel djT;
    private List<FeedForumData> gzq;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.cVg.getOrignalPage()).checkUpIsLogin()) {
                        e.this.djT.eC(feedForumData.getForumName(), feedForumData.getForumId());
                        an anVar = new an("c10048");
                        anVar.cy("fid", feedForumData.getForumId());
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(anVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.cVg.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.cVg.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new an("c10050").cy("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d fVl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bb(e.this.djT.getErrorCode(), e.this.djT.getErrorString())) {
                AntiHelper.bn(e.this.cVg.getPageActivity(), e.this.djT.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.djT.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.djT.getErrorString());
                }
            } else {
                t tVar = (t) obj;
                tVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.cVg = tbPageContext;
        this.djT = new LikeModel(tbPageContext);
        this.djT.setLoadDataCallBack(this.fVl);
    }

    public void setData(List<FeedForumData> list) {
        this.gzq = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gzq != null) {
            return this.gzq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gzq != null) {
            return this.gzq.get(i);
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
            view = LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.gzy.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.eaB.setOnClickListener(this.mOnClickListener);
        bVar.gzv.setPlaceHolder(1);
        bVar.gzv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.gzv.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.gzw.setText(String.format(this.cVg.getPageActivity().getString(R.string.attention_post_count), tp(feedForumData.getMemberCount()), tp(feedForumData.getPostNum())));
        bVar.gzx.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.gzy.setClickable(true);
            bVar.gzy.setOnClickListener(this.mOnClickListener);
            bVar.gzy.setEnabled(true);
            bVar.gzy.fU(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.Ni != this.mSkinType) {
            am.setBackgroundResource(bVar.eaB, R.drawable.frs_like_feed_forum_item_bg);
            am.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            am.setViewTextColor(bVar.gzw, R.color.cp_cont_c, 1);
            am.setViewTextColor(bVar.gzx, R.color.cp_link_tip_d, 1);
            if (bVar.mDivider != null) {
                am.setBackgroundColor(bVar.mDivider, R.color.cp_bg_line_c);
            }
            bVar.Ni = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.gzy != null) {
            bVar.gzy.fU(true);
            bVar.gzy.setEnabled(false);
        }
    }

    private String tp(int i) {
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

    public void a(List<FeedForumData> list, t tVar) {
        if (list != null && list.size() > 0 && tVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(tVar.getFid())) {
                    feedForumData.setIsLike(tVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
