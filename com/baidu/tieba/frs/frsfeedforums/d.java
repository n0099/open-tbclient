package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.base.e;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> eUY;
    private LikeModel fnw;
    private List<FeedForumData> jxq;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) d.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) d.this.eUY.getOrignalPage()).checkUpIsLogin()) {
                        d.this.fnw.gy(feedForumData.getForumName(), feedForumData.getForumId());
                        ar arVar = new ar("c10048");
                        arVar.dR("fid", feedForumData.getForumId());
                        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(arVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    d.this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.eUY.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new ar("c10050").dR("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private e iJl = new e() { // from class: com.baidu.tieba.frs.frsfeedforums.d.2
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (AntiHelper.bX(d.this.fnw.getErrorCode(), d.this.fnw.getErrorString())) {
                AntiHelper.bq(d.this.eUY.getPageActivity(), d.this.fnw.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(d.this.fnw.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), d.this.fnw.getErrorString());
                }
            } else {
                w wVar = (w) obj;
                wVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
            }
        }
    };

    public d(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.eUY = tbPageContext;
        this.fnw = new LikeModel(tbPageContext);
        this.fnw.setLoadDataCallBack(this.iJl);
    }

    public void setData(List<FeedForumData> list) {
        this.jxq = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jxq != null) {
            return this.jxq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jxq != null) {
            return this.jxq.get(i);
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
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.jxy.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.giF.setOnClickListener(this.mOnClickListener);
        bVar.jxv.setPlaceHolder(1);
        bVar.jxv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.jxv.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.jxw.setText(String.format(this.eUY.getPageActivity().getString(R.string.attention_post_count), zD(feedForumData.getMemberCount()), zD(feedForumData.getPostNum())));
        bVar.jxx.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.jxy.setClickable(true);
            bVar.jxy.setOnClickListener(this.mOnClickListener);
            bVar.jxy.setEnabled(true);
            bVar.jxy.aM(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.ajU != this.mSkinType) {
            ap.setBackgroundResource(bVar.giF, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.CAM_X0105, 1);
            ap.setViewTextColor(bVar.jxw, R.color.CAM_X0108, 1);
            ap.setViewTextColor(bVar.jxx, R.color.CAM_X0305, 1);
            if (bVar.dBb != null) {
                ap.setBackgroundColor(bVar.dBb, R.color.CAM_X0204);
            }
            bVar.ajU = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.jxy != null) {
            bVar.jxy.aM(true);
            bVar.jxy.setEnabled(false);
        }
    }

    private String zD(int i) {
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

    public void a(List<FeedForumData> list, w wVar) {
        if (list != null && list.size() > 0 && wVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(wVar.getFid())) {
                    feedForumData.setIsLike(wVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
