package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ChannelAddVideoActivity cDQ;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.cDQ = channelAddVideoActivity;
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
    /* renamed from: iZ */
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
            view = LayoutInflater.from(this.cDQ.getPageContext().getPageActivity()).inflate(f.h.channel_add_video_item_layout, viewGroup, false);
            C0138a c0138a2 = new C0138a();
            c0138a2.cDR = (TbCheckBox) view.findViewById(f.g.item_check_box);
            c0138a2.cDS = (TbImageView) view.findViewById(f.g.video_cover);
            c0138a2.cDT = (TextView) view.findViewById(f.g.video_length);
            c0138a2.title = (TextView) view.findViewById(f.g.title);
            c0138a2.cDU = (TextView) view.findViewById(f.g.forum_from);
            c0138a2.cDV = (TextView) view.findViewById(f.g.intro);
            view.setTag(c0138a2);
            c0138a = c0138a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0138a.cDR.setTagData(item);
            if (item.ajT() == 1) {
                c0138a.cDR.setEnabled(false);
                am.c(c0138a.cDR, f.C0146f.icon_choose_channel_n);
            } else {
                c0138a.cDR.setEnabled(true);
                c0138a.cDR.AD();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0138a.cDS.setTag(null);
                c0138a.cDS.startLoad(item.getThumbnailUrl(), 10, false);
                c0138a.cDS.invalidate();
            }
            c0138a.cDT.setText(ap.cW(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0138a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0138a.cDU.setText(item.getForumName() + "吧");
            }
            c0138a.cDV.setText(ap.A(item.ajS()) + "次播放·" + com.baidu.tieba.channel.c.c.bl(item.getCreateTime()));
        }
        this.cDQ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cDQ.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).ajT() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0138a {
        public TbCheckBox cDR;
        public TbImageView cDS;
        public TextView cDT;
        public TextView cDU;
        public TextView cDV;
        public TextView title;

        public C0138a() {
        }
    }
}
