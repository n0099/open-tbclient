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
    private ChannelAddVideoActivity cZN;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.cZN = channelAddVideoActivity;
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
    /* renamed from: kF */
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
            view = LayoutInflater.from(this.cZN.getPageContext().getPageActivity()).inflate(e.h.channel_add_video_item_layout, viewGroup, false);
            C0207a c0207a2 = new C0207a();
            c0207a2.cZO = (TbCheckBox) view.findViewById(e.g.item_check_box);
            c0207a2.cZP = (TbImageView) view.findViewById(e.g.video_cover);
            c0207a2.cZQ = (TextView) view.findViewById(e.g.video_length);
            c0207a2.title = (TextView) view.findViewById(e.g.title);
            c0207a2.cZR = (TextView) view.findViewById(e.g.forum_from);
            c0207a2.cZS = (TextView) view.findViewById(e.g.intro);
            view.setTag(c0207a2);
            c0207a = c0207a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0207a.cZO.setTagData(item);
            if (item.aqv() == 1) {
                c0207a.cZO.setEnabled(false);
                al.c(c0207a.cZO, e.f.icon_choose_channel_n);
            } else {
                c0207a.cZO.setEnabled(true);
                c0207a.cZO.Fj();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0207a.cZP.setTag(null);
                c0207a.cZP.startLoad(item.getThumbnailUrl(), 10, false);
                c0207a.cZP.invalidate();
            }
            c0207a.cZQ.setText(ao.dR(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0207a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0207a.cZR.setText(item.getForumName() + "吧");
            }
            c0207a.cZS.setText(ao.P(item.aqu()) + "次播放·" + com.baidu.tieba.channel.c.c.bz(item.getCreateTime()));
        }
        this.cZN.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cZN.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).aqv() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0207a {
        public TbCheckBox cZO;
        public TbImageView cZP;
        public TextView cZQ;
        public TextView cZR;
        public TextView cZS;
        public TextView title;

        public C0207a() {
        }
    }
}
