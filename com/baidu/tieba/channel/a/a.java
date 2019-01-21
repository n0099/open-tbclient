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
    private ChannelAddVideoActivity ddt;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.ddt = channelAddVideoActivity;
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
    /* renamed from: kT */
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
        C0207a c0207a;
        if (view != null) {
            c0207a = (C0207a) view.getTag();
        } else {
            view = LayoutInflater.from(this.ddt.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_item_layout, viewGroup, false);
            C0207a c0207a2 = new C0207a();
            c0207a2.ddv = (TbCheckBox) view.findViewById(e.g.item_check_box);
            c0207a2.ddw = (TbImageView) view.findViewById(e.g.video_cover);
            c0207a2.ddx = (TextView) view.findViewById(e.g.video_length);
            c0207a2.title = (TextView) view.findViewById(e.g.title);
            c0207a2.ddy = (TextView) view.findViewById(e.g.forum_from);
            c0207a2.ddz = (TextView) view.findViewById(e.g.intro);
            view.setTag(c0207a2);
            c0207a = c0207a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0207a.ddv.setTagData(item);
            if (item.arI() == 1) {
                c0207a.ddv.setEnabled(false);
                al.c(c0207a.ddv, e.f.icon_choose_channel_n);
            } else {
                c0207a.ddv.setEnabled(true);
                c0207a.ddv.Fw();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0207a.ddw.setTag(null);
                c0207a.ddw.startLoad(item.getThumbnailUrl(), 10, false);
                c0207a.ddw.invalidate();
            }
            c0207a.ddx.setText(ao.dR(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0207a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0207a.ddy.setText(item.getForumName() + "吧");
            }
            c0207a.ddz.setText(ao.Q(item.arH()) + "次播放·" + com.baidu.tieba.channel.c.c.bE(item.getCreateTime()));
        }
        this.ddt.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ddt.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).arI() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0207a {
        public TbCheckBox ddv;
        public TbImageView ddw;
        public TextView ddx;
        public TextView ddy;
        public TextView ddz;
        public TextView title;

        public C0207a() {
        }
    }
}
