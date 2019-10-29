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
    private ChannelAddVideoActivity eSf;
    private List<com.baidu.tieba.channel.data.b> mData;

    public a(ChannelAddVideoActivity channelAddVideoActivity) {
        this.eSf = channelAddVideoActivity;
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
    /* renamed from: oS */
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
        C0395a c0395a;
        if (view != null) {
            c0395a = (C0395a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eSf.getPageContext().getPageActivity()).inflate(R.layout.channel_add_video_item_layout, viewGroup, false);
            C0395a c0395a2 = new C0395a();
            c0395a2.eSg = (TbCheckBox) view.findViewById(R.id.item_check_box);
            c0395a2.eSh = (TbImageView) view.findViewById(R.id.video_cover);
            c0395a2.eSi = (TextView) view.findViewById(R.id.video_length);
            c0395a2.title = (TextView) view.findViewById(R.id.title);
            c0395a2.eSj = (TextView) view.findViewById(R.id.forum_from);
            c0395a2.eSk = (TextView) view.findViewById(R.id.intro);
            view.setTag(c0395a2);
            c0395a = c0395a2;
        }
        com.baidu.tieba.channel.data.b item = getItem(i);
        if (item != null) {
            c0395a.eSg.setTagData(item);
            if (item.bbs() == 1) {
                c0395a.eSg.setEnabled(false);
                am.setImageResource(c0395a.eSg, R.drawable.icon_choose_channel_n);
            } else {
                c0395a.eSg.setEnabled(true);
                c0395a.eSg.anO();
            }
            if (!TextUtils.isEmpty(item.getThumbnailUrl())) {
                c0395a.eSh.setTag(null);
                c0395a.eSh.startLoad(item.getThumbnailUrl(), 10, false);
                c0395a.eSh.invalidate();
            }
            c0395a.eSi.setText(aq.formatSecondsTime(item.getVideoDuration() * 1000));
            if (!TextUtils.isEmpty(item.getTitle())) {
                c0395a.title.setText(item.getTitle());
            }
            if (!TextUtils.isEmpty(item.getForumName())) {
                c0395a.eSj.setText(item.getForumName() + "吧");
            }
            c0395a.eSk.setText(aq.numberUniformFormat(item.bbr()) + "次播放·" + com.baidu.tieba.channel.c.c.cx(item.getCreateTime()));
        }
        this.eSf.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eSf.getLayoutMode().onModeChanged(view);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItem(i).bbs() != 1;
    }

    /* renamed from: com.baidu.tieba.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0395a {
        public TbCheckBox eSg;
        public TbImageView eSh;
        public TextView eSi;
        public TextView eSj;
        public TextView eSk;
        public TextView title;

        public C0395a() {
        }
    }
}
