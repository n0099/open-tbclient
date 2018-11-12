package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ChannelAddVideoActivity cTg;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.cTg = channelAddVideoActivity;
    }

    public List<com.baidu.tieba.channel.data.b> getData() {
        return this.mData;
    }

    public void setData(List<com.baidu.tieba.channel.data.b> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kp */
    public com.baidu.tieba.channel.data.b getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0197a c0197a;
        if (view != null) {
            c0197a = (C0197a) view.getTag();
        } else {
            view = LayoutInflater.from(this.cTg.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_item_layout, viewGroup, false);
            C0197a c0197a2 = new C0197a();
            c0197a2.cTh = (TbCheckBox) view.findViewById(e.g.item_check_box);
            c0197a2.cTi = (TbImageView) view.findViewById(e.g.video_cover);
            c0197a2.cTj = (TextView) view.findViewById(e.g.video_length);
            c0197a2.title = (TextView) view.findViewById(e.g.title);
            c0197a2.cTk = (TextView) view.findViewById(e.g.forum_from);
            c0197a2.cTl = (TextView) view.findViewById(e.g.intro);
            view.setTag(c0197a2);
            c0197a = c0197a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0197a.cTh.setTagData(item);
            if (item.aoI() == 1) {
                c0197a.cTh.setEnabled(false);
                al.c(c0197a.cTh, e.f.icon_choose_channel_n);
            } else {
                c0197a.cTh.setEnabled(true);
                c0197a.cTh.Ef();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0197a.cTi.setTag(null);
                c0197a.cTi.startLoad(item.getThumbnailUrl(), 10, false);
                c0197a.cTi.invalidate();
            }
            c0197a.cTj.setText(ao.dD(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0197a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0197a.cTk.setText(item.getForumName() + "吧");
            }
            c0197a.cTl.setText(ao.I(item.aoH()) + "次播放·" + com.baidu.tieba.channel.c.c.bs(item.getCreateTime()));
        }
        this.cTg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cTg.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).aoI() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0197a {
        public TbCheckBox cTh;
        public TbImageView cTi;
        public TextView cTj;
        public TextView cTk;
        public TextView cTl;
        public TextView title;

        public C0197a() {
        }
    }
}
