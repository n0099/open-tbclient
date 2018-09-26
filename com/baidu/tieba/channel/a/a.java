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
    private ChannelAddVideoActivity cJH;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.cJH = channelAddVideoActivity;
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
    /* renamed from: jy */
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
        C0138a c0138a;
        if (view != null) {
            c0138a = (C0138a) view.getTag();
        } else {
            view = LayoutInflater.from(this.cJH.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_item_layout, viewGroup, false);
            C0138a c0138a2 = new C0138a();
            c0138a2.cJI = (TbCheckBox) view.findViewById(e.g.item_check_box);
            c0138a2.cJJ = (TbImageView) view.findViewById(e.g.video_cover);
            c0138a2.cJK = (TextView) view.findViewById(e.g.video_length);
            c0138a2.title = (TextView) view.findViewById(e.g.title);
            c0138a2.cJL = (TextView) view.findViewById(e.g.forum_from);
            c0138a2.cJM = (TextView) view.findViewById(e.g.intro);
            view.setTag(c0138a2);
            c0138a = c0138a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0138a.cJI.setTagData(item);
            if (item.alE() == 1) {
                c0138a.cJI.setEnabled(false);
                al.c(c0138a.cJI, e.f.icon_choose_channel_n);
            } else {
                c0138a.cJI.setEnabled(true);
                c0138a.cJI.BQ();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0138a.cJJ.setTag(null);
                c0138a.cJJ.startLoad(item.getThumbnailUrl(), 10, false);
                c0138a.cJJ.invalidate();
            }
            c0138a.cJK.setText(ao.df(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0138a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0138a.cJL.setText(item.getForumName() + "吧");
            }
            c0138a.cJM.setText(ao.E(item.alD()) + "次播放·" + com.baidu.tieba.channel.c.c.bp(item.getCreateTime()));
        }
        this.cJH.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cJH.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).alE() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0138a {
        public TbCheckBox cJI;
        public TbImageView cJJ;
        public TextView cJK;
        public TextView cJL;
        public TextView cJM;
        public TextView title;

        public C0138a() {
        }
    }
}
