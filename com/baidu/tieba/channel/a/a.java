package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ChannelAddVideoActivity ctH;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.ctH = channelAddVideoActivity;
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
    /* renamed from: iP */
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0122a c0122a;
        if (view2 != null) {
            c0122a = (C0122a) view2.getTag();
        } else {
            view2 = LayoutInflater.from(this.ctH.getPageContext().getPageActivity()).inflate(d.i.channel_add_video_item_layout, viewGroup, false);
            C0122a c0122a2 = new C0122a();
            c0122a2.ctI = (TbCheckBox) view2.findViewById(d.g.item_check_box);
            c0122a2.ctJ = (TbImageView) view2.findViewById(d.g.video_cover);
            c0122a2.ctK = (TextView) view2.findViewById(d.g.video_length);
            c0122a2.title = (TextView) view2.findViewById(d.g.title);
            c0122a2.ctL = (TextView) view2.findViewById(d.g.forum_from);
            c0122a2.ctM = (TextView) view2.findViewById(d.g.intro);
            view2.setTag(c0122a2);
            c0122a = c0122a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0122a.ctI.setTagData(item);
            if (item.agq() == 1) {
                c0122a.ctI.setEnabled(false);
                ak.c(c0122a.ctI, d.f.icon_choose_channel_n);
            } else {
                c0122a.ctI.setEnabled(true);
                c0122a.ctI.wY();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0122a.ctJ.setTag(null);
                c0122a.ctJ.startLoad(item.getThumbnailUrl(), 10, false);
                c0122a.ctJ.invalidate();
            }
            c0122a.ctK.setText(an.cQ(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0122a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0122a.ctL.setText(item.getForumName() + "吧");
            }
            c0122a.ctM.setText(an.v(item.agp()) + "次播放·" + com.baidu.tieba.channel.c.c.bj(item.getCreateTime()));
        }
        this.ctH.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.ctH.getLayoutMode().u(view2);
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).agq() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0122a {
        public TbCheckBox ctI;
        public TbImageView ctJ;
        public TextView ctK;
        public TextView ctL;
        public TextView ctM;
        public TextView title;

        public C0122a() {
        }
    }
}
