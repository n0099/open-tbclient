package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class c extends m {
    private EditText eMG;

    public c(Context context) {
        super(context, (String) null, 29);
        this.eLs = false;
        this.eLr = 3;
        this.eKx = new TopicDetaiInputContainer(context);
        this.eMG = ((TopicDetaiInputContainer) this.eKx).getInputView();
        ((TopicDetaiInputContainer) this.eKx).setHint(context.getString(R.string.say_your_point));
        this.eLt = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.eMG;
    }
}
