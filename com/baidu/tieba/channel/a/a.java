package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelAddVideoActivity;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ChannelAddVideoActivity eJA;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.eJA = channelAddVideoActivity;
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
    /* renamed from: pQ */
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
        C0306a c0306a;
        if (view != null) {
            c0306a = (C0306a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eJA.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_item_layout, viewGroup, false);
            C0306a c0306a2 = new C0306a();
            c0306a2.eJB = (TbCheckBox) view.findViewById(R.id.item_check_box);
            c0306a2.eJC = (TbImageView) view.findViewById(R.id.video_cover);
            c0306a2.eJD = (TextView) view.findViewById(R.id.video_length);
            c0306a2.title = (TextView) view.findViewById(R.id.title);
            c0306a2.eJE = (TextView) view.findViewById(R.id.forum_from);
            c0306a2.eJF = (TextView) view.findViewById(R.id.intro);
            view.setTag(c0306a2);
            c0306a = c0306a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0306a.eJB.setTagData(item);
            if (item.bbo() == 1) {
                c0306a.eJB.setEnabled(false);
                am.c(c0306a.eJB, (int) R.drawable.icon_choose_channel_n);
            } else {
                c0306a.eJB.setEnabled(true);
                c0306a.eJB.akZ();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0306a.eJC.setTag(null);
                c0306a.eJC.startLoad(item.getThumbnailUrl(), 10, false);
                c0306a.eJC.invalidate();
            }
            c0306a.eJD.setText(aq.ip(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0306a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0306a.eJE.setText(item.getForumName() + "吧");
            }
            c0306a.eJF.setText(aq.aH(item.bbn()) + "次播放·" + com.baidu.tieba.channel.c.c.cJ(item.getCreateTime()));
        }
        this.eJA.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eJA.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).bbo() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0306a {
        public TbCheckBox eJB;
        public TbImageView eJC;
        public TextView eJD;
        public TextView eJE;
        public TextView eJF;
        public TextView title;

        public C0306a() {
        }
    }
}
