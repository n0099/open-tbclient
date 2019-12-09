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
    private ChannelAddVideoActivity eRo;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.eRo = channelAddVideoActivity;
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
    /* renamed from: oR */
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
        C0390a c0390a;
        if (view != null) {
            c0390a = (C0390a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eRo.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_item_layout, viewGroup, false);
            C0390a c0390a2 = new C0390a();
            c0390a2.eRp = (TbCheckBox) view.findViewById(R.id.item_check_box);
            c0390a2.eRq = (TbImageView) view.findViewById(R.id.video_cover);
            c0390a2.eRr = (TextView) view.findViewById(R.id.video_length);
            c0390a2.title = (TextView) view.findViewById(R.id.title);
            c0390a2.eRs = (TextView) view.findViewById(R.id.forum_from);
            c0390a2.eRt = (TextView) view.findViewById(R.id.intro);
            view.setTag(c0390a2);
            c0390a = c0390a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0390a.eRp.setTagData(item);
            if (item.bbq() == 1) {
                c0390a.eRp.setEnabled(false);
                am.setImageResource(c0390a.eRp, R.drawable.icon_choose_channel_n);
            } else {
                c0390a.eRp.setEnabled(true);
                c0390a.eRp.anM();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0390a.eRq.setTag(null);
                c0390a.eRq.startLoad(item.getThumbnailUrl(), 10, false);
                c0390a.eRq.invalidate();
            }
            c0390a.eRr.setText(aq.formatSecondsTime(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0390a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0390a.eRs.setText(item.getForumName() + "吧");
            }
            c0390a.eRt.setText(aq.numberUniformFormat(item.bbp()) + "次播放·" + com.baidu.tieba.channel.c.c.cw(item.getCreateTime()));
        }
        this.eRo.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eRo.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).bbq() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0390a {
        public TbCheckBox eRp;
        public TbImageView eRq;
        public TextView eRr;
        public TextView eRs;
        public TextView eRt;
        public TextView title;

        public C0390a() {
        }
    }
}
