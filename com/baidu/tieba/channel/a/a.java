package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ChannelAddVideoActivity dbO;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.dbO = channelAddVideoActivity;
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
    /* renamed from: lF */
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
        C0137a c0137a;
        if (view != null) {
            c0137a = (C0137a) view.getTag();
        } else {
            view = LayoutInflater.from(this.dbO.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_item_layout, viewGroup, false);
            C0137a c0137a2 = new C0137a();
            c0137a2.dbP = (TbCheckBox) view.findViewById(d.g.item_check_box);
            c0137a2.dbQ = (TbImageView) view.findViewById(d.g.video_cover);
            c0137a2.dbR = (TextView) view.findViewById(d.g.video_length);
            c0137a2.title = (TextView) view.findViewById(d.g.title);
            c0137a2.dbS = (TextView) view.findViewById(d.g.forum_from);
            c0137a2.dbT = (TextView) view.findViewById(d.g.intro);
            view.setTag(c0137a2);
            c0137a = c0137a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0137a.dbP.setTagData(item);
            if (item.amp() == 1) {
                c0137a.dbP.setEnabled(false);
                aj.c(c0137a.dbP, d.f.icon_choose_channel_n);
            } else {
                c0137a.dbP.setEnabled(true);
                c0137a.dbP.Em();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0137a.dbQ.setTag(null);
                c0137a.dbQ.startLoad(item.getThumbnailUrl(), 10, false);
                c0137a.dbQ.invalidate();
            }
            c0137a.dbR.setText(am.fR(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0137a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0137a.dbS.setText(item.getForumName() + "吧");
            }
            c0137a.dbT.setText(am.C(item.amo()) + "次播放·" + com.baidu.tieba.channel.c.c.bl(item.getCreateTime()));
        }
        this.dbO.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.dbO.getLayoutMode().aM(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).amp() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0137a {
        public TbCheckBox dbP;
        public TbImageView dbQ;
        public TextView dbR;
        public TextView dbS;
        public TextView dbT;
        public TextView title;

        public C0137a() {
        }
    }
}
