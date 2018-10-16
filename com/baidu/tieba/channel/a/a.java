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
    private ChannelAddVideoActivity cSa;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.cSa = channelAddVideoActivity;
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
    /* renamed from: jW */
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
        C0172a c0172a;
        if (view != null) {
            c0172a = (C0172a) view.getTag();
        } else {
            view = LayoutInflater.from(this.cSa.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_item_layout, viewGroup, false);
            C0172a c0172a2 = new C0172a();
            c0172a2.cSb = (TbCheckBox) view.findViewById(e.g.item_check_box);
            c0172a2.cSc = (TbImageView) view.findViewById(e.g.video_cover);
            c0172a2.cSd = (TextView) view.findViewById(e.g.video_length);
            c0172a2.title = (TextView) view.findViewById(e.g.title);
            c0172a2.cSe = (TextView) view.findViewById(e.g.forum_from);
            c0172a2.cSf = (TextView) view.findViewById(e.g.intro);
            view.setTag(c0172a2);
            c0172a = c0172a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0172a.cSb.setTagData(item);
            if (item.apg() == 1) {
                c0172a.cSb.setEnabled(false);
                al.c(c0172a.cSb, e.f.icon_choose_channel_n);
            } else {
                c0172a.cSb.setEnabled(true);
                c0172a.cSb.DV();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0172a.cSc.setTag(null);
                c0172a.cSc.startLoad(item.getThumbnailUrl(), 10, false);
                c0172a.cSc.invalidate();
            }
            c0172a.cSd.setText(ao.dp(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0172a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0172a.cSe.setText(item.getForumName() + "吧");
            }
            c0172a.cSf.setText(ao.G(item.apf()) + "次播放·" + com.baidu.tieba.channel.c.c.bw(item.getCreateTime()));
        }
        this.cSa.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cSa.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).apg() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0172a {
        public TbCheckBox cSb;
        public TbImageView cSc;
        public TextView cSd;
        public TextView cSe;
        public TextView cSf;
        public TextView title;

        public C0172a() {
        }
    }
}
