package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class i implements o {
    private int Or;
    private int evB;
    HeadImageView evX;
    ImageView evY;
    TextView evZ;
    CreateGroupStepActivity evx;
    private com.baidu.adp.widget.ImageView.a ewa = null;
    private a ewb = null;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.evx = null;
        this.mView = null;
        this.evX = null;
        this.evY = null;
        this.evZ = null;
        this.evx = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step3_view, (ViewGroup) null);
        this.evY = (ImageView) this.mView.findViewById(e.g.step3_img_bg);
        this.evX = (HeadImageView) this.mView.findViewById(e.g.step3_img_scr);
        this.evZ = (TextView) this.mView.findViewById(e.g.create_group3);
        this.mIndex = i;
        this.Or = i2;
        this.evB = i3;
    }

    public void aKF() {
        if (this.ewb != null) {
            this.ewb.cancel();
        }
        this.ewa = null;
        this.ewb = new a();
        this.ewb.execute(new Object[0]);
    }

    public ImageView aKG() {
        return this.evY;
    }

    public TextView aKH() {
        return this.evZ;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aKq() {
        this.evY.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aKr() {
        this.evx.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.evx.getLayoutMode().onModeChanged(this.mView);
        this.evX.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.l.ah(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.evX.setVisibility(0);
                i.this.ewa = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.ewa.a(i.this.evX);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.evx.getPageContext().getString(e.j.group_create_step_photo), Integer.valueOf(this.Or));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aKt() {
        if (this.mIndex != this.evB) {
            return this.evx.getPageContext().getString(e.j.next_step);
        }
        return this.evx.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aKu() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aKk() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aKv() {
        return true;
    }
}
