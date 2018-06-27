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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ChannelAddVideoActivity cBo;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.cBo = channelAddVideoActivity;
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
    /* renamed from: iO */
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
        C0140a c0140a;
        if (view != null) {
            c0140a = (C0140a) view.getTag();
        } else {
            view = LayoutInflater.from(this.cBo.getPageContext().getPageActivity()).inflate(d.i.channel_add_video_item_layout, viewGroup, false);
            C0140a c0140a2 = new C0140a();
            c0140a2.cBp = (TbCheckBox) view.findViewById(d.g.item_check_box);
            c0140a2.cBq = (TbImageView) view.findViewById(d.g.video_cover);
            c0140a2.cBr = (TextView) view.findViewById(d.g.video_length);
            c0140a2.title = (TextView) view.findViewById(d.g.title);
            c0140a2.cBs = (TextView) view.findViewById(d.g.forum_from);
            c0140a2.cBt = (TextView) view.findViewById(d.g.intro);
            view.setTag(c0140a2);
            c0140a = c0140a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0140a.cBp.setTagData(item);
            if (item.ajs() == 1) {
                c0140a.cBp.setEnabled(false);
                am.c(c0140a.cBp, d.f.icon_choose_channel_n);
            } else {
                c0140a.cBp.setEnabled(true);
                c0140a.cBp.AP();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0140a.cBq.setTag(null);
                c0140a.cBq.startLoad(item.getThumbnailUrl(), 10, false);
                c0140a.cBq.invalidate();
            }
            c0140a.cBr.setText(ap.cU(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0140a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0140a.cBs.setText(item.getForumName() + "吧");
            }
            c0140a.cBt.setText(ap.z(item.ajr()) + "次播放·" + com.baidu.tieba.channel.c.c.bh(item.getCreateTime()));
        }
        this.cBo.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.cBo.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).ajs() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0140a {
        public TbCheckBox cBp;
        public TbImageView cBq;
        public TextView cBr;
        public TextView cBs;
        public TextView cBt;
        public TextView title;

        public C0140a() {
        }
    }
}
