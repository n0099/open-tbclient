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
    private ChannelAddVideoActivity dbR;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.dbR = channelAddVideoActivity;
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
            view = LayoutInflater.from(this.dbR.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_item_layout, viewGroup, false);
            C0137a c0137a2 = new C0137a();
            c0137a2.dbS = (TbCheckBox) view.findViewById(d.g.item_check_box);
            c0137a2.dbT = (TbImageView) view.findViewById(d.g.video_cover);
            c0137a2.dbU = (TextView) view.findViewById(d.g.video_length);
            c0137a2.title = (TextView) view.findViewById(d.g.title);
            c0137a2.dbV = (TextView) view.findViewById(d.g.forum_from);
            c0137a2.dbW = (TextView) view.findViewById(d.g.intro);
            view.setTag(c0137a2);
            c0137a = c0137a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0137a.dbS.setTagData(item);
            if (item.amq() == 1) {
                c0137a.dbS.setEnabled(false);
                aj.c(c0137a.dbS, d.f.icon_choose_channel_n);
            } else {
                c0137a.dbS.setEnabled(true);
                c0137a.dbS.En();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0137a.dbT.setTag(null);
                c0137a.dbT.startLoad(item.getThumbnailUrl(), 10, false);
                c0137a.dbT.invalidate();
            }
            c0137a.dbU.setText(am.fR(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0137a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0137a.dbV.setText(item.getForumName() + "吧");
            }
            c0137a.dbW.setText(am.C(item.amp()) + "次播放·" + com.baidu.tieba.channel.c.c.bl(item.getCreateTime()));
        }
        this.dbR.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.dbR.getLayoutMode().aM(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).amq() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0137a {
        public TbCheckBox dbS;
        public TbImageView dbT;
        public TextView dbU;
        public TextView dbV;
        public TextView dbW;
        public TextView title;

        public C0137a() {
        }
    }
}
