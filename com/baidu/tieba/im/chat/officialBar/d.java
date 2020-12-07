package com.baidu.tieba.im.chat.officialBar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> ajO = new ArrayList<>();
    private c kmn;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes26.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.kmn = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ajO.clear();
            this.ajO.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.ajO != null && this.ajO.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ajO.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ajO == null) {
            return 0;
        }
        return this.ajO.size();
    }

    /* loaded from: classes26.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView jAw;
        private BarImageView kmp;
        private View kmq;
        private a kmr;

        b(View view) {
            super(view);
            this.kmp = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.jAw = (TextView) view.findViewById(R.id.official_bar_name);
            this.kmq = view.findViewById(R.id.official_bar_feed_red_dot);
            this.kmp.setShowOval(true);
            this.kmp.setPlaceHolder(2);
            this.kmp.setShowOuterBorder(false);
            this.kmp.setShowInnerBorder(true);
            this.kmp.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.kmr = (a) aVar;
            ap.setViewTextColor(this.jAw, R.color.CAM_X0105);
            ap.setBackgroundResource(this.kmq, R.drawable.icon_official_bar_red_dot);
            this.kmp.setStrokeColorResId(R.color.CAM_X0401);
            this.kmp.startLoad(this.kmr.cTX(), 10, false);
            if (au.getChineseAndEnglishLength(this.kmr.cNU()) <= 10) {
                this.jAw.setText(this.kmr.cNU());
            } else {
                this.jAw.setText(au.cutChineseAndEnglishWithSuffix(this.kmr.cNU(), 8, StringHelper.STRING_MORE));
            }
            this.kmp.setOnClickListener(this);
            if (this.kmr.getUnReadCount() > 0 && (this.kmr.cTY() <= 0 || System.currentTimeMillis() - this.kmr.cTY() < 864000000)) {
                this.kmq.setVisibility(0);
            } else {
                this.kmq.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.kmq.setVisibility(8);
            if (d.this.kmn != null) {
                d.this.kmn.a(view, this.kmr, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long cWM;
        private long groupId;
        private String jLw;
        private String kmo;
        private int unReadCount;
        private int userType;

        String cTX() {
            return this.kmo;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cNU() {
            return this.jLw;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void MM(String str) {
            this.kmo = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void MN(String str) {
            this.jLw = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cTY() {
            return this.cWM;
        }

        public void gM(long j) {
            this.cWM = j;
        }
    }
}
