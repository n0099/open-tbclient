package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ChannelAddVideoActivity enc;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.enc = channelAddVideoActivity;
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
    /* renamed from: or */
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
        C0275a c0275a;
        if (view != null) {
            c0275a = (C0275a) view.getTag();
        } else {
            view = LayoutInflater.from(this.enc.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_item_layout, viewGroup, false);
            C0275a c0275a2 = new C0275a();
            c0275a2.ene = (TbCheckBox) view.findViewById(d.g.item_check_box);
            c0275a2.enf = (TbImageView) view.findViewById(d.g.video_cover);
            c0275a2.eng = (TextView) view.findViewById(d.g.video_length);
            c0275a2.title = (TextView) view.findViewById(d.g.title);
            c0275a2.enh = (TextView) view.findViewById(d.g.forum_from);
            c0275a2.eni = (TextView) view.findViewById(d.g.intro);
            view.setTag(c0275a2);
            c0275a = c0275a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0275a.ene.setTagData(item);
            if (item.aRx() == 1) {
                c0275a.ene.setEnabled(false);
                al.c(c0275a.ene, d.f.icon_choose_channel_n);
            } else {
                c0275a.ene.setEnabled(true);
                c0275a.ene.aeH();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0275a.enf.setTag(null);
                c0275a.enf.startLoad(item.getThumbnailUrl(), 10, false);
                c0275a.enf.invalidate();
            }
            c0275a.eng.setText(ap.hu(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0275a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0275a.enh.setText(item.getForumName() + "吧");
            }
            c0275a.eni.setText(ap.as(item.aRw()) + "次播放·" + com.baidu.tieba.channel.c.c.ce(item.getCreateTime()));
        }
        this.enc.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.enc.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).aRx() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0275a {
        public TbCheckBox ene;
        public TbImageView enf;
        public TextView eng;
        public TextView enh;
        public TextView eni;
        public TextView title;

        public C0275a() {
        }
    }
}
