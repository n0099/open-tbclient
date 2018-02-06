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
    private ChannelAddVideoActivity dca;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.dca = channelAddVideoActivity;
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
        C0136a c0136a;
        if (view != null) {
            c0136a = (C0136a) view.getTag();
        } else {
            view = LayoutInflater.from(this.dca.getPageContext().getPageActivity()).inflate(d.h.channel_add_video_item_layout, viewGroup, false);
            C0136a c0136a2 = new C0136a();
            c0136a2.dcb = (TbCheckBox) view.findViewById(d.g.item_check_box);
            c0136a2.dcc = (TbImageView) view.findViewById(d.g.video_cover);
            c0136a2.dcd = (TextView) view.findViewById(d.g.video_length);
            c0136a2.title = (TextView) view.findViewById(d.g.title);
            c0136a2.dce = (TextView) view.findViewById(d.g.forum_from);
            c0136a2.dcf = (TextView) view.findViewById(d.g.intro);
            view.setTag(c0136a2);
            c0136a = c0136a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0136a.dcb.setTagData(item);
            if (item.amq() == 1) {
                c0136a.dcb.setEnabled(false);
                aj.c(c0136a.dcb, d.f.icon_choose_channel_n);
            } else {
                c0136a.dcb.setEnabled(true);
                c0136a.dcb.En();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0136a.dcc.setTag(null);
                c0136a.dcc.startLoad(item.getThumbnailUrl(), 10, false);
                c0136a.dcc.invalidate();
            }
            c0136a.dcd.setText(am.fR(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0136a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0136a.dce.setText(item.getForumName() + "吧");
            }
            c0136a.dcf.setText(am.C(item.amp()) + "次播放·" + com.baidu.tieba.channel.c.c.bl(item.getCreateTime()));
        }
        this.dca.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.dca.getLayoutMode().aM(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).amq() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0136a {
        public TbCheckBox dcb;
        public TbImageView dcc;
        public TextView dcd;
        public TextView dce;
        public TextView dcf;
        public TextView title;

        public C0136a() {
        }
    }
}
